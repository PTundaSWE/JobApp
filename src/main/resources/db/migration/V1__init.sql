-- =========================================
-- V1__init.sql
-- Initial schema for Job Application
-- =========================================

-- ---------------------------
-- Main job post table
-- ---------------------------
CREATE TABLE job_posts (
                           post_id BIGSERIAL PRIMARY KEY,
                           post_profile VARCHAR(255) NOT NULL,
                           post_desc TEXT NOT NULL,
                           req_experience INT NOT NULL
);

-- ---------------------------
-- Tech stack table (1-to-many)
-- ---------------------------
CREATE TABLE job_post_tech_stack (
                                     id BIGSERIAL PRIMARY KEY,
                                     post_id BIGINT NOT NULL,
                                     tech_name VARCHAR(100) NOT NULL,

                                     CONSTRAINT fk_job_post
                                         FOREIGN KEY (post_id)
                                             REFERENCES job_posts(post_id)
                                             ON DELETE CASCADE
);

-- ---------------------------
-- Indexes for performance
-- ---------------------------
CREATE INDEX idx_job_posts_profile ON job_posts(post_profile);
CREATE INDEX idx_tech_stack_post_id ON job_post_tech_stack(post_id);
CREATE INDEX idx_tech_stack_name ON job_post_tech_stack(tech_name);
