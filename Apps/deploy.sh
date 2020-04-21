cp /root/workspace/apps/Apps/build/libs/*.war /opt/tomcat/webapps/ROOT
cd /opt/tomcat/webapps/ROOT
jar xvf Apps-0.1.war
cd /opt/tomcat/bin
./shutdown.sh
cd /opt/tomcat/logs
rm -rf *


