package com.csc340.crud_api_jpa_demo.repository;

import com.csc340.crud_api_jpa_demo.objects.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatisticsRepository extends JpaRepository<Statistics, Integer> {
}
