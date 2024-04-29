# Dockerfile

# 사용할 베이스 이미지 선택
FROM openjdk

# 어플리케이션 JAR 파일 복사
COPY ./module-web/api/build/libs/*.jar /app/supreme-online-app.jar

# 어플리케이션 실행
CMD ["java", "-jar", "/app/supreme-online-app.jar"]
