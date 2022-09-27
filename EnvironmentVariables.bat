set SRCPATH=S:
set JAVA_HOME=%SRCPATH%\Tools\jdk-8u131-windows-x64
set ROO_HOME=%SRCPATH%\Tools\spring-roo-2.0.0.RELEASE
set M2_HOME=%SRCPATH%\Tools\apache-maven-3.5.3
set JVM_ARGS="-Xmx1024m -XX:MaxPermSize=512m" 
set MAVEN_OPTS="-DmemTest='-XX:MaxPermSize=1024m'"
set SCRIPTS=%SRCPATH%\Tools\SCRIPTS
set PATH=%JAVA_HOME%\bin;%ROO_HOME%\bin;%M2_HOME%\bin;%SCRIPTS%;%PATH%

