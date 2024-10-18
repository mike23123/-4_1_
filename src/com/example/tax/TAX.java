package com.example.tax;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TAX extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 获取请求参数
        double income = Double.parseDouble(request.getParameter("income"));
        double deductions = Double.parseDouble(request.getParameter("deductions"));

        // 计算税款
        double tax = calculatePersonalIncomeTax(income, deductions);

        // 设置响应类型和编码
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // 发送响应
        PrintWriter out = response.getWriter();
        out.print("{ \"tax\": " + tax + " }");
        out.flush();
    }

    private double calculatePersonalIncomeTax(double income, double deductions) {
        // 这里添加个人所得税计算逻辑
        double taxableIncome = income - deductions;
        double tax = 0.0;

        // 示例税率计算逻辑（请根据实际税法进行调整）
        if (taxableIncome <= 3600) {
            tax = 0;
        } else if (taxableIncome <= 5000) {
            tax = (taxableIncome - 3600) * 0.03;
        } else if (taxableIncome <= 8000) {
            tax = (5000 - 3600) * 0.03 + (taxableIncome - 5000) * 0.1;
        }

        return tax;
    }
}