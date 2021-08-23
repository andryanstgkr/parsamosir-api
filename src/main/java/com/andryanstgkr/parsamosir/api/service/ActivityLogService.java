package com.andryanstgkr.parsamosir.api.service;

import com.andryanstgkr.parsamosir.api.model.ActivityLog;

import org.springframework.stereotype.Service;

@Service
public class ActivityLogService extends BaseService<ActivityLog, String>{

    @Override
    public ActivityLog update(ActivityLog t, String activity, String id) {
        return null;
    }
    
}
