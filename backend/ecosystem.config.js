module.exports = {
  apps: [
    {
      name: "config-server",
      script: "java",
      args: "-jar /home/Yashoda/config-server/target/config-server-0.0.1-SNAPSHOT.jar",
      interpreter: "none",
      autorestart: true,
      watch: false
    },
    {
      name: "eureka-server",
      script: "java",
      args: "-jar /home/Yashoda/eureka-server/target/eureka-server-0.0.1-SNAPSHOT.jar",
      interpreter: "none",
      autorestart: true,
      watch: false
    },
    {
      name: "user-service",
      script: "java",
      args: "-jar /home/Yashoda/user-service/target/user-service-0.0.1-SNAPSHOT.jar",
      interpreter: "none",
      autorestart: true,
      watch: false
    },
    {
      name: "request-service",
      script: "java",
      args: "-jar /home/Yashoda/request-service/target/request-service-0.0.1-SNAPSHOT.jar",
      interpreter: "none",
      autorestart: true,
      watch: false
    },
    {
      name: "provider-service",
      script: "java",
      args: "-jar /home/Yashoda/provider-service/target/provider-service-0.0.1-SNAPSHOT.jar",
      interpreter: "none",
      autorestart: true,
      watch: false
    },
    {
      name: "api-gateway",
      script: "java",
      args: "-jar /home/Yashoda/api-gateway/target/api-gateway-0.0.1-SNAPSHOT.jar",
      interpreter: "none",
      autorestart: true,
      watch: false
    }
  ]
};