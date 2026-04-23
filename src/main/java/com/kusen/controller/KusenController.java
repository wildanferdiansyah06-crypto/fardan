package com.kusen.controller;

import com.kusen.model.CartItem;
import com.kusen.model.Kusen;
import com.kusen.model.Order;
import com.kusen.model.OrderItem;
import com.kusen.repository.CartItemRepository;
import com.kusen.repository.KusenRepository;
import com.kusen.repository.OrderItemRepository;
import com.kusen.repository.OrderRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
public class KusenController {

    @Autowired
    private KusenRepository kusenRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @ModelAttribute
    public void addCartCount(@CookieValue(value = "sessionId", defaultValue = "") String sessionId, Model model) {
        if (!sessionId.isEmpty()) {
            int cartCount = cartItemRepository.findBySessionId(sessionId).size();
            model.addAttribute("cartCount", cartCount);
        } else {
            model.addAttribute("cartCount", 0);
        }
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("kusenList", kusenRepository.findByTersediaTrue());
        model.addAttribute("featuredProducts", kusenRepository.findByTersediaTrue().stream().limit(4).toList());
        return "index";
    }

    @GetMapping("/produk")
    public String listProduk(Model model) {
        model.addAttribute("kusenList", kusenRepository.findByTersediaTrue());
        return "produk";
    }

    @GetMapping("/tentang")
    public String tentang(Model model) {
        return "tentang";
    }

    @GetMapping("/kontak")
    public String kontak(Model model) {
        return "kontak";
    }

    @GetMapping("/produk/cari")
    public String cariProduk(@RequestParam("keyword") String keyword, Model model) {
        model.addAttribute("kusenList", kusenRepository.findByNamaContainingIgnoreCaseAndTersediaTrue(keyword));
        model.addAttribute("keyword", keyword);
        return "produk";
    }

    @GetMapping("/kategori/{kategori}")
    public String filterByKategori(@PathVariable String kategori, Model model) {
        model.addAttribute("kusenList", kusenRepository.findByKategoriAndTersediaTrue(kategori));
        model.addAttribute("kategoriFilter", kategori);
        return "produk";
    }

    @GetMapping("/produk/{id}")
    public String detailProduk(@PathVariable Long id, Model model) {
        Kusen kusen = kusenRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produk tidak ditemukan: " + id));
        model.addAttribute("kusen", kusen);
        return "detail";
    }

    @GetMapping("/jenis/{jenisKayu}")
    public String filterByJenis(@PathVariable String jenisKayu, Model model) {
        model.addAttribute("kusenList", kusenRepository.findByJenisKayuAndTersediaTrue(jenisKayu));
        model.addAttribute("jenisFilter", jenisKayu);
        return "produk";
    }

    @GetMapping("/tambah-produk")
    public String formTambahProduk(Model model) {
        model.addAttribute("kusen", new Kusen());
        return "form-produk";
    }

    @PostMapping("/tambah-produk")
    public String simpanProduk(@ModelAttribute Kusen kusen) {
        kusen.setTersedia(true);
        kusenRepository.save(kusen);
        return "redirect:/produk";
    }

    @GetMapping("/edit/{id}")
    public String formEditProduk(@PathVariable Long id, Model model) {
        Kusen kusen = kusenRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produk tidak ditemukan: " + id));
        model.addAttribute("kusen", kusen);
        return "form-produk";
    }

    @PostMapping("/edit/{id}")
    public String updateProduk(@PathVariable Long id, @ModelAttribute Kusen kusen) {
        kusen.setId(id);
        kusenRepository.save(kusen);
        return "redirect:/produk/" + id;
    }

    @GetMapping("/hapus/{id}")
    public String hapusProduk(@PathVariable Long id) {
        kusenRepository.deleteById(id);
        return "redirect:/produk";
    }

    // Cart functionality
    private String getSessionId(@CookieValue(value = "sessionId", defaultValue = "") String sessionId, HttpServletResponse response) {
        if (sessionId.isEmpty()) {
            sessionId = UUID.randomUUID().toString();
            Cookie cookie = new Cookie("sessionId", sessionId);
            cookie.setMaxAge(30 * 24 * 60 * 60); // 30 days
            cookie.setPath("/");
            response.addCookie(cookie);
        }
        return sessionId;
    }

    @PostMapping("/cart/add")
    public String addToCart(@RequestParam Long productId, @RequestParam(defaultValue = "1") Integer quantity,
                           @CookieValue(value = "sessionId", defaultValue = "") String sessionId,
                           HttpServletResponse response) {
        sessionId = getSessionId(sessionId, response);
        Kusen product = kusenRepository.findById(productId).orElse(null);
        if (product != null) {
            CartItem existingItem = cartItemRepository.findBySessionIdAndProductId(sessionId, productId).orElse(null);
            if (existingItem != null) {
                existingItem.setQuantity(existingItem.getQuantity() + quantity);
                cartItemRepository.save(existingItem);
            } else {
                CartItem cartItem = new CartItem(product, quantity, sessionId);
                cartItemRepository.save(cartItem);
            }
        }
        return "redirect:/produk";
    }

    @GetMapping("/cart")
    public String viewCart(@CookieValue(value = "sessionId", defaultValue = "") String sessionId,
                          HttpServletResponse response, Model model) {
        sessionId = getSessionId(sessionId, response);
        List<CartItem> cartItems = cartItemRepository.findBySessionId(sessionId);
        Double total = cartItems.stream().mapToDouble(CartItem::getTotalPrice).sum();
        model.addAttribute("cartItems", cartItems);
        model.addAttribute("total", total);
        return "cart";
    }

    @PostMapping("/cart/update")
    public String updateCart(@RequestParam Long itemId, @RequestParam Integer quantity,
                            @CookieValue(value = "sessionId", defaultValue = "") String sessionId,
                            HttpServletResponse response) {
        sessionId = getSessionId(sessionId, response);
        CartItem cartItem = cartItemRepository.findById(itemId).orElse(null);
        if (cartItem != null && cartItem.getSessionId().equals(sessionId)) {
            if (quantity > 0) {
                cartItem.setQuantity(quantity);
                cartItemRepository.save(cartItem);
            } else {
                cartItemRepository.delete(cartItem);
            }
        }
        return "redirect:/cart";
    }

    @GetMapping("/cart/remove/{id}")
    public String removeFromCart(@PathVariable Long id,
                               @CookieValue(value = "sessionId", defaultValue = "") String sessionId,
                               HttpServletResponse response) {
        sessionId = getSessionId(sessionId, response);
        CartItem cartItem = cartItemRepository.findById(id).orElse(null);
        if (cartItem != null && cartItem.getSessionId().equals(sessionId)) {
            cartItemRepository.delete(cartItem);
        }
        return "redirect:/cart";
    }

    @GetMapping("/cart/clear")
    public String clearCart(@CookieValue(value = "sessionId", defaultValue = "") String sessionId,
                           HttpServletResponse response) {
        sessionId = getSessionId(sessionId, response);
        cartItemRepository.deleteBySessionId(sessionId);
        return "redirect:/cart";
    }

    // Checkout functionality
    @GetMapping("/checkout")
    public String checkout(@CookieValue(value = "sessionId", defaultValue = "") String sessionId,
                          HttpServletResponse response, Model model) {
        sessionId = getSessionId(sessionId, response);
        List<CartItem> cartItems = cartItemRepository.findBySessionId(sessionId);
        
        if (cartItems.isEmpty()) {
            return "redirect:/cart";
        }
        
        Double total = cartItems.stream().mapToDouble(CartItem::getTotalPrice).sum();
        model.addAttribute("cartItems", cartItems);
        model.addAttribute("total", total);
        return "checkout";
    }

    @PostMapping("/checkout")
    public String processCheckout(@RequestParam String nama, @RequestParam String email,
                                 @RequestParam String telepon, @RequestParam String alamat,
                                 @RequestParam(required = false) String catatan,
                                 @CookieValue(value = "sessionId", defaultValue = "") String sessionId,
                                 HttpServletResponse response, Model model) {
        sessionId = getSessionId(sessionId, response);
        List<CartItem> cartItems = cartItemRepository.findBySessionId(sessionId);
        
        if (cartItems.isEmpty()) {
            return "redirect:/cart";
        }
        
        Double total = cartItems.stream().mapToDouble(CartItem::getTotalPrice).sum();
        
        // Create order
        Order order = new Order(nama, email, telepon, alamat, total, sessionId, catatan);
        order = orderRepository.save(order);
        
        // Create order items
        for (CartItem cartItem : cartItems) {
            OrderItem orderItem = new OrderItem(order, cartItem.getProduct(), 
                cartItem.getQuantity(), cartItem.getProduct().getHarga());
            orderItemRepository.save(orderItem);
        }
        
        // Clear cart
        cartItemRepository.deleteBySessionId(sessionId);
        
        model.addAttribute("order", order);
        return "order-confirmation";
    }

    @GetMapping("/pesanan")
    public String pesanan(@CookieValue(value = "sessionId", defaultValue = "") String sessionId,
                         HttpServletResponse response, Model model) {
        sessionId = getSessionId(sessionId, response);
        List<Order> orders = orderRepository.findBySessionId(sessionId);
        model.addAttribute("orders", orders);
        return "pesanan";
    }
}
