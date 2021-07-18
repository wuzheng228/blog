FROM java:8
ARG JAR_FILE=zzspace-blog.jar
COPY ${JAR_FILE} /root/startup/
WORKDIR /root/startup/
EXPOSE 80
EXPOSE 443
ENTRYPOINT ["java","-jar","zzspace-blog.jar"]
