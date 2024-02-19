package com.group.libraryapp.dto.hw2.response;

import com.group.libraryapp.dto.hw2.request.CalcRequest;

public class CalcResponse {
    private int addVal;
    private int minusVal;
    private int multiplyVal;

    public CalcResponse(CalcRequest request) {
        this.addVal = request.getNum1() + request.getNum2();
        this.minusVal = request.getNum1() - request.getNum2();
        this.multiplyVal = request.getNum1() * request.getNum2();
    }

    public int getAddVal() {
        return addVal;
    }

    public int getMinusVal() {
        return minusVal;
    }

    public int getMultiplyVal() {
        return multiplyVal;
    }
}
