package org.paul.springbootlearning.jobapp;

import org.paul.springbootlearning.jobapp.model.JobPost;
import org.paul.springbootlearning.jobapp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class JobController {

    @Autowired
    private JobService jobService;

    // call the homepage
    // @RequestMapping("/") and @GetMapping("/") are equivalent
    @RequestMapping({"/", "home"})
    public String home() {
        return "home";
    }

    @GetMapping("/addjob")
    public String addJob(){
        return "addjob";
    }

    @PostMapping(value = "/handleForm")
    public String handleForm(@ModelAttribute JobPost jobPost){
        jobService.addJob(jobPost);
        return "success";
    }

    @GetMapping(value = "/viewalljobs")
    public String viewAllJobs(Model model){
        List<JobPost> jobs = jobService.getAllJobs();
        model.addAttribute("jobPosts", jobs);
        return "viewalljobs";
    }
}
