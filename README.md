# ServiceHub – Home Service Request System

## Student Information

| Field | Details |
|---|---|
| Student Name | Yashoda Gunawardhana |
| Student ID | 241711077 |
| GCP Project ID | Not Created Yet |

## Project Overview

ServiceHub is a cloud-based Home Service Request System developed using a microservices architecture.

The main purpose of ServiceHub is to provide a platform where customers can request home-based services and service providers can manage and respond to service requests.

The system separates major business functionalities into independent microservices. This makes the application easier to develop, maintain, scale, and deploy independently.

The project also demonstrates cloud-native concepts such as:

- Microservices Architecture
- Service Discovery
- Centralized Configuration
- API Gateway
- Relational Database
- Non-Relational Database
- Cloud Storage
- Cloud Deployment
- Load Balancing
- Auto Scaling
- High Availability

## Main Features

The ServiceHub system provides the following main features:

- Customer registration
- Customer login
- User management
- Customer dashboard
- Service request creation
- Service request viewing
- Service request updating
- Service request status management
- Service provider management
- Provider profile management
- Service provider related operations
- File/image upload support
- Centralized configuration
- Service discovery
- API Gateway based communication

## System Architecture

ServiceHub follows a microservices-based architecture.

The system consists of three business microservices:

1. User Service
2. Request Service
3. Provider Service

The project also contains three platform services:

1. Config Server
2. Eureka Server
3. API Gateway

The frontend is developed using React.

## High-Level Architecture

```
+---------------------------+
|      ServiceHub Web       |
|     React Frontend        |
+-------------+-------------+
              |
              v
+---------------------------+
|       API Gateway         |
|          :8080            |
+-------------+-------------+
              |
      +-------+-------+
      |       |       |
      v       v       v
   User    Request  Provider
  Service  Service   Service
   :8081     :8082     :8083
      |        |         |
      v        v         v
    MySQL   MongoDB    MySQL


+---------------------------+
|      Eureka Server        |
|          :8761            |
|     Service Discovery     |
+---------------------------+

+---------------------------+
|       Config Server       |
|          :8888            |
| Centralized Configuration |
+---------------------------+
```

## Microservices

### User Service

The User Service is responsible for managing user-related functionality within the ServiceHub system.

Main responsibilities include:

- User registration
- User login
- User authentication
- User information management
- Customer management
- User role management

**Database:** MySQL
**Port:** 8081

### Request Service

The Request Service manages customer service requests.

Customers can use this service to create and manage requests for home services.

Main responsibilities include:

- Create service requests
- View service requests
- Update service requests
- Manage request status
- Manage request-related information
- Store service request data

**Database:** MongoDB
**Port:** 8082

### Provider Service

The Provider Service is responsible for managing service provider-related functionality.

Main responsibilities include:

- Service provider management
- Provider profile management
- Provider availability
- Provider-related operations
- Service provider information management

**Database:** MySQL
**Port:** 8083

## Platform Services

### Config Server

The Config Server provides centralized configuration management for all microservices.

Instead of maintaining configuration separately in every microservice, configuration properties can be maintained centrally using Spring Cloud Config Server.

**Port:** 8888

### Eureka Server

The Eureka Server acts as the service registry and service discovery component of the ServiceHub architecture.

Microservices register themselves with Eureka Server so that other services can discover available service instances.

**Port:** 8761

**Eureka Dashboard:** http://localhost:8761

### API Gateway

The API Gateway acts as the single entry point for client requests.

The frontend communicates with the API Gateway instead of directly accessing individual microservices.

The API Gateway routes requests to the appropriate backend service.

**Port:** 8080

## Database Architecture

ServiceHub uses both relational and non-relational database technologies.

### Relational Database – MySQL

MySQL is used for structured relational data.

Services using MySQL:

- User Service
- Provider Service

### Non-Relational Database – MongoDB

MongoDB is used for non-relational service request data.

Service using MongoDB:

- Request Service

## Technology Stack

### Backend

- Java
- Spring Boot
- Spring Cloud
- Spring Data
- Spring Cloud Config
- Netflix Eureka
- Spring Cloud Gateway
- Maven

### Frontend

- React
- Vite
- JavaScript
- React Router
- Axios
- Tailwind CSS

### Databases

- MySQL
- MongoDB

### Version Control

- Git
- GitHub
- Git Submodules

### Cloud Platform

- Google Cloud Platform (GCP)

## Frontend

The ServiceHub frontend is developed using React and Vite.

The frontend communicates with the backend through the API Gateway.

Main frontend pages and functionality include:

- Login
- Registration
- Customer Dashboard
- Service Request Management
- Provider-related functionality

## Repository Structure

The project follows a polyrepo architecture using Git submodules.

```
ServiceHub
│
├── .github
│
├── backend
│   │
│   ├── platform
│   │   │
│   │   ├── api-gateway
│   │   │
│   │   ├── config-server
│   │   │
│   │   └── eureka-server
│   │
│   └── services
│       │
│       ├── user-service
│       │
│       ├── request-service
│       │
│       └── provider-service
│
├── frontend
│   │
│   └── servicehub-web
│
├── config-repository
│
└── .gitmodules
```

## Git Submodules

The following repositories are maintained as separate GitHub repositories and included in the ServiceHub project as Git submodules.

**Platform components:**

- api-gateway
- config-server
- eureka-server

**Business services:**

- user-service
- request-service
- provider-service

## Getting Started

### Prerequisites

The following software and tools are required to run the project locally:

- JDK
- Maven
- Node.js
- npm
- Git
- MySQL
- MongoDB

### Clone the Repository

Clone the main repository together with all submodules:

```bash
git clone --recurse-submodules https://github.com/yashodha-gunawardana/ServiceHub.git
```

Navigate to the project:

```bash
cd ServiceHub
```

If the repository has already been cloned without submodules, initialize the submodules using:

```bash
git submodule update --init --recursive
```

## Running the Backend

The backend services should be started in the following order:

1. Config Server
2. Eureka Server
3. User Service
4. Request Service
5. Provider Service
6. API Gateway

### Run Config Server

Navigate to:

```bash
cd backend/platform/config-server
```

Run:

```bash
.\mvnw.cmd spring-boot:run
```

Config Server: http://localhost:8888

### Run Eureka Server

Navigate to:

```bash
cd backend/platform/eureka-server
```

Run:

```bash
.\mvnw.cmd spring-boot:run
```

Eureka Dashboard: http://localhost:8761

### Run User Service

Navigate to:

```bash
cd backend/services/user-service
```

Run:

```bash
.\mvnw.cmd spring-boot:run
```

User Service: http://localhost:8081

### Run Request Service

Navigate to:

```bash
cd backend/services/request-service
```

Run:

```bash
.\mvnw.cmd spring-boot:run
```

Request Service: http://localhost:8082

### Run Provider Service

Navigate to:

```bash
cd backend/services/provider-service
```

Run:

```bash
.\mvnw.cmd spring-boot:run
```

Provider Service: http://localhost:8083

### Run API Gateway

Navigate to:

```bash
cd backend/platform/api-gateway
```

Run:

```bash
.\mvnw.cmd spring-boot:run
```

API Gateway: http://localhost:8080

## Frontend Setup

Navigate to the frontend directory:

```bash
cd frontend/servicehub-web
```

Install dependencies:

```bash
npm install
```

Start the development server:

```bash
npm run dev
```

The Vite development server will display the frontend URL in the terminal.

## API Communication

The frontend communicates with backend services through the API Gateway.

The communication flow is:

```
React Frontend
      |
      v
API Gateway :8080
      |
      +------------------+
      |                  |
      v                  v
User Service       Request Service
   :8081               :8082
      |
      v
Provider Service
    :8083
```

## Configuration Management

ServiceHub uses Spring Cloud Config Server for centralized configuration management.

The project contains a configuration repository:

```
config-repository/
```

The Config Server provides centralized configuration information to the application services.

## Service Discovery

ServiceHub uses Netflix Eureka for service discovery.

The microservices register themselves with the Eureka Server.

The service discovery flow is:

```
User Service
      |
Request Service
      |
Provider Service
      |
      v
Eureka Server :8761
```

## Cloud Storage

Google Cloud Storage will be integrated into ServiceHub to store files associated with service requests.

A planned use case is allowing customers to upload images when creating a service request.

The planned flow is:

```
Customer
   |
   v
Create Service Request
   |
   v
Upload Image
   |
   v
API Gateway
   |
   v
Request Service
   |
   v
Google Cloud Storage
```

The final Google Cloud Storage configuration will be added after the GCP project is created.

## Google Cloud Platform Deployment

ServiceHub is planned to be deployed on Google Cloud Platform.

The deployment architecture will use cloud infrastructure and managed services.

Planned GCP components include:

- Virtual Private Cloud (VPC)
- Firewall Rules
- Cloud Router
- Cloud NAT
- Compute Engine
- Instance Templates
- Managed Instance Groups
- Virtual Machines
- Health Checks
- Load Balancing
- Cloud SQL
- Cloud Storage
- Cloud Run
- Cloud DNS
- Service Accounts

## Backend Deployment

The backend platform services and microservices are planned to be deployed using Google Compute Engine virtual machines.

The planned deployment architecture is:

```
Instance Template
       |
       v
Managed Instance Group
       |
       v
Multiple VM Instances
       |
       v
Load Balancer
       |
       v
Backend Services
```

## Frontend Deployment

The React frontend is planned to be deployed using Google Cloud Run.

The planned deployment flow is:

```
React Application
       |
       v
Google Cloud Run
       |
       v
Public Web Application
```

## Cloud Database Deployment

MySQL is planned to be deployed using Google Cloud SQL.

The planned architecture is:

```
User Service
      |
      v
Cloud SQL
   MySQL
```

The final database deployment configuration will be added after the GCP environment is created.

The MongoDB cloud deployment will also be configured during the cloud deployment stage.

## Load Balancing

Google Cloud Load Balancing will be used to distribute incoming traffic across backend application instances.

The planned architecture is:

```
Client
  |
  v
Load Balancer
  |
  +----------------+
  |                |
  v                v
VM 01            VM 02
  |                |
  +--------+-------+
           |
           v
    Backend Services
```

## Auto Scaling

Managed Instance Groups will be used to support horizontal auto scaling.

The number of backend application instances can be increased or decreased according to system demand.

The planned architecture is:

```
Managed Instance Group
         |
   +-----+-----+
   |           |
   v           v
 VM 01       VM 02
   |
   v
Auto Scaling
```

## High Availability

High availability will be supported through multiple application instances, health checks, managed instance groups, and load balancing.

Multiple instances reduce the impact of individual VM failures and improve application availability.

## Health Checks

Google Cloud health checks will be configured to monitor backend application instances.

Unhealthy instances can be identified and replaced through the managed instance group configuration.

## Networking

The GCP deployment will use a Virtual Private Cloud network.

Planned networking components include:

- VPC Network
- Subnets
- Firewall Rules
- Cloud Router
- Cloud NAT
- Private networking
- Controlled access to backend resources

## Cloud DNS

Cloud DNS will be configured for domain name resolution after the cloud infrastructure has been deployed.

The final domain configuration will be added to this README once the domain is configured.

## Service Accounts

Google Cloud service accounts will be used where required for secure communication between applications and GCP services.

Permissions will be configured according to the principle of least privilege.

## Security

Security considerations for the project include:

- VPC networking
- Firewall rules
- IAM permissions
- Service accounts
- Secure configuration
- Restricted database access
- Protection of sensitive information
- Avoiding credentials in GitHub repositories

Database passwords, API keys, cloud credentials, and other sensitive information should not be committed to GitHub.

## Git Workflow

Each microservice and platform component is maintained in its own GitHub repository.

Changes should first be committed and pushed to the relevant submodule repository.

After updating a submodule, the parent ServiceHub repository should be updated with the new submodule commit.

Recommended workflow:

```
Change Code
    |
    v
Enter Submodule
    |
    v
git add .
    |
    v
git commit
    |
    v
git push
    |
    v
Return to ServiceHub
    |
    v
git add <submodule>
    |
    v
git commit
    |
    v
git push
```

## GCP Project Information

GCP Project ID: `Not Created Yet`

The GCP Project ID and cloud infrastructure details will be updated after the Google Cloud project is created.

## Future Improvements

Possible future improvements include:

- Service provider matching
- Real-time notifications
- Online payment integration
- Service ratings and reviews
- Advanced search and filtering
- Mobile application
- Advanced monitoring and logging
- Improved authentication and authorization

## Author

Yashoda Gunawardhana

Student ID: 241711077

## Academic Project

This project is developed as an academic project for:

ITS 2130 – Enterprise Cloud Architecture