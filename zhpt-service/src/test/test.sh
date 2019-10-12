#来自基础镜像
FROM centos:7
FROM primetoninc/jdk:1.8
#指定镜像创建者信息
MAINTAINER SDW
#切换工作目录
WORKDIR /usr/local
#创建一个存放EUREKA jar包的路径
RUN mkdir /usr/local/eureka
#将jdk压缩包复制并解压到容器中
ADD zhpt-eureka-server.jar /usr/local/eureka


#开发端口
EXPOSE 8101

 docker run -it --name=eureka  -p 8101:8101   16b5dc18f990  /bin/bash


CMD ["/bin/bash"]
