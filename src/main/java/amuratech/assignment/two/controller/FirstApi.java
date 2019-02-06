package amuratech.assignment.two.controller;


import amuratech.assignment.two.model.InputParam;
import amuratech.assignment.two.service.impl.subMatrixImpl;
import amuratech.assignment.two.service.subMatrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FirstApi {

    private subMatrix subMatrix;

    @Autowired
    public void setFirstAPIService(subMatrix subMatrix) {
        this.subMatrix = subMatrix;
    }

    @PostMapping("/returningSubMatrix")
    public String result(@RequestBody InputParam param){
        String inp = "1 0 0 0 0 1,0 1 1 1 0 0,0 1 1 1 0 0,0 1 1 1 1 0";
        if(null != param.getInput()){
            inp = param.getInput();
        }
        String ret = subMatrix.subMatrixresult(inp);
        return ret;
    }
}
