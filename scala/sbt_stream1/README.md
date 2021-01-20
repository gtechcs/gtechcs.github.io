
#Install Hadoop on local MAC
https://towardsdatascience.com/installing-hadoop-on-a-mac-ec01c67b003c
brew install hadoop
$cd /usr/local/cellar/hadoop/3.3.0/libexec/etc/hadoop
$cd /usr/local/cellar/hadoop/3.3.0/libexec/sbin
$ ./start-all.sh
$ jps
http://localhost:9870
$ ./stop-all.sh

#Hadoop commands, http://localhost:9870/explorer.html#/
hadoop fs -ls /
hadoop fs -mkdir /user


#Kafka on Mac
https://medium.com/@at_ishikawa/getting-started-with-kafka-on-mac-f6aa8924fcda
Issue: Kafka has issues connecting to zookeeper. Trying to connect to Hadoop Data node (127.0.0.1:9866)	http://a23-202-231-169.deploy.static.akamaitechnologies.com:9864

#Kafka on Mac Attempt 2
https://kafka.apache.org/documentation/#quickstart
Changes: 
a. remove logs directory under kafka
b. Run zookeeper on different port  clientPort=2182
c. Ser ser.properties
listeners=PLAINTEXT://127.0.0.1:9092
advertised.listeners=PLAINTEXT://127.0.0.1:9092
