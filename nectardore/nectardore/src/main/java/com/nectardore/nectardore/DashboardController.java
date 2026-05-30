package com.nectardore.nectardore;
import org.springframework.web.bind.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dashboard")
public class DashboardController{
    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService){
        this.dashboardService=dashboardService;
    }
    @GetMapping("/summary")
    public DashboardSummary getSummary(){
       return dashboardService.getSummary();
    }
}