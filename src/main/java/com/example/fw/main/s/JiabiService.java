package com.example.fw.main.s;

import com.example.fw.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class JiabiService extends BaseService {
    @Override
    protected String getTabName() {
        return "jiabiuser";
    }
}
