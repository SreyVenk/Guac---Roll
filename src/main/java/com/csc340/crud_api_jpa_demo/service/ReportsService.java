package com.csc340.crud_api_jpa_demo.service;

import com.csc340.crud_api_jpa_demo.objects.Reports;
import com.csc340.crud_api_jpa_demo.repository.ReportsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportsService {

    @Autowired
    private ReportsRepository reportsRepository;

    public List<Reports> getAllReports() {
        return reportsRepository.findAll();
    }

    public Reports saveReport(Reports report) {
        return reportsRepository.save(report);
    }

    public Reports updateReport(int id, Reports reportDetails) {
        Reports report = reportsRepository.findById(id).orElseThrow();
        report.setContentId(reportDetails.getContentId());
        report.setReportType(reportDetails.getReportType());
        report.setReportedId(reportDetails.getReportedId());
        report.setReason(reportDetails.getReason());
        report.setCreatedAt(reportDetails.getCreatedAt());
        report.setUpdatedAt(reportDetails.getUpdatedAt());
        report.setStatus(reportDetails.getStatus());
        return reportsRepository.save(report);
    }

    public void deleteReport(int id) {
        reportsRepository.deleteById(id);
    }
}
