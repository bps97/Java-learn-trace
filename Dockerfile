# FROM frolvlad/alpine-oraclejdk8:slim
FROM openjdk:8-jdk-alpine

ADD target/ssm-heam-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]


# docker build -t ssm-heam:0.0.1 .


#FROM openjdk:8-jdk-alpine
#VOLUME /tmp
#ADD target/ssm-heam-0.0.1-SNAPSHOT.jar app.jar
#ENV JAVA_OPTS=""
#ENTRYPOINT exec java $JAVA_OPTS -jar /app.jar

# 第一行的FROM命令，指定了我们这个镜像基于openjdk这个镜像制作。

# 第二行的VOLUME命令，定义了一个持久化存储，指向容器中的tmp文件夹。SpringBoot应用为内置的Tomcat服务器实例创建的默认工作目录为tmp，通过该命令，可以在运行Docker的宿主机目录/var/lib/docker创建一个临时的目录，挂接到容器内部的tmp去。

# 如果你的SpringBoot应用不会进行持久化写操作，则该步骤可以省略。

# 第三行，把本地目录下target文件夹里打好的jar文件添加到容器里，重命名为app.jar.

# 第四行：ENV命令的作用是设置环境变量。在复杂的使用场景中，我们可能需要使用各种参数启动JVM，这些参数通过ENV命令设置的环境变量传入Java命令。在这个简单的例子里可以省略环境变量的设置。

# 第五行：ENTRYPOINT，顾名思义，容器镜像运行的起始点。
