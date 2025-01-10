package com.example.flinkwebapp.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

//for Angular Client (withCredentials)
//@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600, allowCredentials="true")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public String userAccess() {
        return "User Content.";
    }

    @GetMapping("/mod")
    @PreAuthorize("hasRole('MODERATOR')")
    public String moderatorAccess() {
        return "Moderator Board.";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }

    @PostMapping("/SourceConfig")
    @PreAuthorize("hasRole('USER')")
    String SourceConfigFormSubmission(@RequestParam Map<String,String> formData, Model model){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt", false))) {
            writer.write("Name: " + formData.get("name") + "\n");
            writer.write("Email: " + formData.get("email") + "\n");
            writer.write("Message: " + formData.get("message") + "\n");
            writer.write("-----\n");
        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("error", "Failed to write data to file.");
            return "error"; // Return an error view
        }

        // Add success message to model
        model.addAttribute("message", "Data submitted successfully!");
        return "success"; // Return a success view
    }
}
