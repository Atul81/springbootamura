package amuratech.assignment.two.service.impl;

import amuratech.assignment.two.service.subMatrix;
import org.springframework.stereotype.Service;

import java.util.Stack;


@Service
public class subMatrixImpl implements subMatrix {

    static String maxHist(int R, int C, int[] row) {
        Stack<Integer> result = new Stack<>();

        int top_val;
        int i = 0;
        int rowRet = 0;
        int colRet = 0;
        int temp = 0;
        int max_area = 0; // Initialize max area in current

        int area = 0;
        while (i < C) {
            if (result.empty() || row[result.peek()] <= row[i])
                result.push(i++);

            else {
                top_val = row[result.peek()];
                result.pop();
                area = top_val * i;
                if (!result.empty()) {
                    temp = i - result.peek();
                    area = top_val * (temp - 1);
                }
                max_area = Math.max(area, max_area);
                rowRet = Math.max(rowRet, temp);
                colRet = Math.max(colRet, top_val);
            }
        }
        while (!result.empty()) {
            top_val = row[result.peek()];
            result.pop();
            area = top_val * i;
            if (!result.empty()) {
                temp = i - result.peek();
                area = top_val * (temp - 1);
            }
            max_area = Math.max(area, max_area);
            rowRet = Math.max(rowRet, temp);
            colRet = Math.max(colRet, top_val);
        }
        return String.format("%d %d %d", max_area, rowRet, colRet);
    }

    static String maxRectangle(int R, int C, int[][] A) {
        // Calculate area for first row and initialize it as
        // result
        String[] re = maxHist(R, C, A[0]).split("\\s");
        int result = Integer.parseInt(re[0]);
        int row = Integer.parseInt(re[1]);
        int col = Integer.parseInt(re[2]);

        for (int i = 1; i < R; i++) {

            for (int j = 0; j < C; j++)

                // if A[i][j] is 1 then add A[i -1][j]
                if (A[i][j] == 1)
                    A[i][j] += A[i - 1][j];

                String[] ret = maxHist(R, C, A[i]).split("\\s");
                result = Math.max(result, Integer.parseInt(ret[0]));
                row = Math.max(row, Integer.parseInt(ret[1]));
                col = Math.max(col, Integer.parseInt(ret[2]));
        }
        return String.format("%d %d", col, result / col);
    }

    @Override
    public String subMatrixresult(String inp) {

        String[] inpb = inp.split(",");
        int c = inpb[0].toCharArray().length;
        String[][] funcParam = new String[inpb.length][c];
        for(int i = 0; i < inpb.length; i++){
            String[] split = inpb[i].split("\\s");
            for(c =0; c < split.length ; c++ ) {
                funcParam[i][c] = split[c];
            }
        }

        int R = funcParam.length;
        int C = c;
        int[][] A = new int[R][C];
        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                A[i][j] = Integer.parseInt(funcParam[i][j]);
        String[] ret = maxRectangle(R,C, A).split("\\s");
        return ("The longest submatrix with 1s is x =1 y =1 length = " + Integer.parseInt(ret[0]) + " height = " + Integer.parseInt(ret[1]));
    }
}
