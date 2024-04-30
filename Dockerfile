# Dockerfile

# 사용할 베이스 이미지 선택
FROM openjdk:21

# 어플리케이션 JAR 파일 복사
COPY ./service-order/build/libs/*.jar /app/order.jar

# 어플리케이션 실행
CMD ["java", "-jar", "/app/order.jar"]
