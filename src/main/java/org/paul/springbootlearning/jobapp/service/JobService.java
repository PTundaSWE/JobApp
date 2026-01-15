package org.paul.springbootlearning.jobapp.service;

import org.paul.springbootlearning.jobapp.model.JobPost;
import org.paul.springbootlearning.jobapp.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// class that handles business logic
// we will view jobs and add new jobs
@Service
public class JobService {

    @Autowired
    private JobRepo jobRepo;

    public void addJob(JobPost jobPost) {
        jobRepo.addJob(jobPost);
    }

    public List<JobPost> getAllJobs() {
        return jobRepo.getAllJobs();
    }
}
