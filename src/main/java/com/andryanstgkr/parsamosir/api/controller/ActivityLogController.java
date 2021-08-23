package com.andryanstgkr.parsamosir.api.controller;

import com.andryanstgkr.parsamosir.api.base.BaseController;
import com.andryanstgkr.parsamosir.api.model.ActivityLog;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "activitylog")
public class ActivityLogController extends BaseController<ActivityLog>{
    
}
