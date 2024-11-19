package com.csc340.crud_api_jpa_demo.controllers;

import com.csc340.crud_api_jpa_demo.objects.Reports;
import com.csc340.crud_api_jpa_demo.service.ReportsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportsController {

    @Autowired
    private ReportsService reportsService;

    @GetMapping
    public List<Reports> getAllReports() {
        return reportsService.getAllReports();
    }

    @PostMapping
    public Reports createReport(@RequestBody Reports report) {
        return reportsService.saveReport(report);
    }

    @PutMapping("/{id}")
    public Reports updateReport(@PathVariable int id, @RequestBody Reports reportDetails) {
        return reportsService.updateReport(id, reportDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteReport(@PathVariable int id) {
        reportsService.deleteReport(id);
    }
}
