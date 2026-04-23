@REM ----------------------------------------------------------------------------
@REM Licensed to the Apache Software Foundation (ASF) under one
@REM or more contributor license agreements.  See the NOTICE file
@REM distributed with this work for additional information
@REM regarding copyright ownership.  The ASF licenses this file
@REM to you under the Apache License, Version 2.0 (the
@REM "License"); you may not use this file except in compliance
@REM with the License.  You may obtain a copy of the License at
@REM
@REM    https://www.apache.org/licenses/LICENSE-2.0
@REM
@REM Unless required by applicable law or agreed to in writing,
@REM software distributed under the License is distributed on
@REM an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
@REM KIND, either express or implied.  See the License for the
@REM specific language governing permissions and limitations
@REM under the License.
@REM ----------------------------------------------------------------------------

@REM ----------------------------------------------------------------------------
@REM Maven Start Up Batch script
@REM
@REM Required ENV vars:
@REM ------------------
@REM JAVA_HOME - location of a JDK home dir
@REM
@REM Optional ENV vars
@REM -----------------
@REM M2_HOME - location of maven2's installed home dir
@REM MAVEN_OPTS - parameters passed to the Java VM when running Maven
@REM     e.g. to debug Maven itself, use
@REM set MAVEN_OPTS=-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=8000
@REM MAVEN_SKIP_RC - flag to disable loading of mavenrc files
@REM ----------------------------------------------------------------------------

@REM Begin all REM lines with '@REM', trailing '@REM' removed on ECHO
@REM to avoid them being output
@echo off
@REM set title of command window
title %0
@REM enable echoing by setting MYSSHELL to -x
set MYSSHELL=

@REM set %HOME% to equivalent of $HOME
if "%HOME%"=="" (set HOME=%USERPROFILE%)

@REM Execute a user defined script before this one
if not "%MAVEN_SKIP_RC%"=="" goto skipRcPre
@REM check for pre script, once with genuine .bat extension and once with .cmd
if exist "%HOME%\mavenrc_pre.bat" call "%HOME%\mavenrc_pre.bat"
if exist "%HOME%\mavenrc_pre.cmd" call "%HOME%\mavenrc_pre.cmd"
:skipRcPre

@setlocal

set ERROR_CODE=0

@REM To isolate internal variables from possible post scripts, we use another setlocal
@setlocal

@REM ==== START VALIDATION ====
if not "%JAVA_HOME%"=="" goto OkJHome

echo.
echo Error: JAVA_HOME environment variable is not set.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.
echo.
goto error

:OkJHome
if exist "%JAVA_HOME%\bin\java.exe" goto init

echo.
echo Error: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.
echo.
goto error

@REM ==== END VALIDATION ====

:init

@REM Find the project base dir, i.e. the directory that contains the folder ".mvn".
@REM Fallback to current working directory if not found.

set MAVEN_PROJECTBASEDIR=%MAVEN_BASEDIR%
if not "%MAVEN_PROJECTBASEDIR%"=="" goto endDetectBaseDir

set EXEC_DIR=%CD%
set WDIR=%EXEC_DIR%
:findBaseDir
if exist "%WDIR%\.mvn" goto baseDirFound
cd ..
if "%WDIR%"=="%CD%" goto baseDirNotFound
set WDIR=%CD%
goto findBaseDir

:baseDirFound
set MAVEN_PROJECTBASEDIR=%WDIR%
cd "%EXEC_DIR%"
goto endDetectBaseDir

:baseDirNotFound
set MAVEN_PROJECTBASEDIR=%EXEC_DIR%
cd "%EXEC_DIR%

:endDetectBaseDir

IF NOT EXIST "%MAVEN_PROJECTBASEDIR%\.mvn\wrapper\maven-wrapper.jar" (
    echo.
    echo ERROR: %MAVEN_PROJECTBASEDIR%\.mvn\wrapper\maven-wrapper.jar does not exist
    echo.
    echo Please download it from:
    echo https://repo.maven.apache.org/maven2/org/apache/maven/wrapper/maven-wrapper/3.2.0/maven-wrapper-3.2.0.jar
    echo.
    echo Then place it in: %MAVEN_PROJECTBASEDIR%\.mvn\wrapper
    echo.
    goto error
)

@REM ==== START EXECUTION ====

set MAVEN_OPTS=%MAVEN_OPTS% -Xmx1024m

@REM Execute Maven
"%JAVA_HOME%\bin\java.exe" %MAVEN_OPTS% -classpath "%MAVEN_PROJECTBASEDIR%\.mvn\wrapper\maven-wrapper.jar" org.apache.maven.wrapper.MavenWrapperMain %MAVEN_CONFIG% %MAVEN_ARGS%

:error
set ERROR_CODE=1

@endlocal
@endlocal

@REM Execute a user defined script after this one
if not "%MAVEN_SKIP_RC%"=="" goto skipRcPost
@REM check for post script, once with genuine .bat extension and once with .cmd
if exist "%HOME%\mavenrc_post.bat" call "%HOME%\mavenrc_post.bat"
if exist "%HOME%\mavenrc_post.cmd" call "%HOME%\mavenrc_post.cmd"
:skipRcPost

@REM pause the script if MAVEN_BATCH_PAUSE is set to 'on'
if "%MAVEN_BATCH_PAUSE%"=="on" pause

if "%MAVEN_TERMINATE_CMD%"=="on" exit %ERROR_CODE%

exit /B %ERROR_CODE%
