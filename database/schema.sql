CREATE DATABASE IF NOT EXISTS ai_research_platform
  CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE ai_research_platform;

CREATE TABLE IF NOT EXISTS users (
                                     id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                     name VARCHAR(100) NOT NULL,
    email VARCHAR(190) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    role ENUM('ADMIN', 'RESEARCHER') NOT NULL DEFAULT 'RESEARCHER',
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
    );

CREATE TABLE IF NOT EXISTS research_projects (
                                                 id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                                 name VARCHAR(160) NOT NULL,
    description TEXT,
    status ENUM('PLANNING', 'ACTIVE', 'COMPLETED', 'ON_HOLD') NOT NULL DEFAULT 'PLANNING',
    lead_researcher_id BIGINT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_project_lead FOREIGN KEY (lead_researcher_id) REFERENCES users(id) ON DELETE SET NULL
    );
