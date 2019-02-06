package amuratech.assignment.two;

import amuratech.assignment.two.controller.FirstApi;
import amuratech.assignment.two.model.InputParam;
import amuratech.assignment.two.service.subMatrix;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.validation.BindingResult;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    private FirstApi firstApi;

    private amuratech.assignment.two.service.subMatrix subMatrix;

    private BindingResult bindingResult;

    @Before
    public void setUp() {
        firstApi = new FirstApi();
        subMatrix = mock(subMatrix.class);
        bindingResult = mock(BindingResult.class);

        firstApi.setFirstAPIService(subMatrix);
    }

    @Test
    public void resultTest() {
        InputParam param = new InputParam();
        String input = "1 0 0 0 0 1,0 1 1 1 0 0,0 1 1 1 0 0,0 0 0 1 0 0";
        param.setInput(input);
        String response = "The longest submatrix with 1s is x =1 y =1 length = 3 height = 2";
        when(subMatrix.subMatrixresult(input)).thenReturn(response);
        firstApi.result(param);
    }

}

