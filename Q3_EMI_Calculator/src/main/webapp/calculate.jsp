<%@ page import="java.text.DecimalFormat" %>

<%
    
    double principal = Double.parseDouble(request.getParameter("principal"));
    double interest = Double.parseDouble(request.getParameter("interest"));
    int time = Integer.parseInt(request.getParameter("time"));

   
    double rate = interest / 100 / 12;
    double emi = (principal * rate * Math.pow(1 + rate, time)) / (Math.pow(1 + rate, time) - 1);
    double totalAmount = emi * time;

    
    DecimalFormat decimalFormat = new DecimalFormat("#.##");
    String formattedEmi = decimalFormat.format(emi);
    String formattedTotalAmount = decimalFormat.format(totalAmount);
%>

<!DOCTYPE html>
<html>
<head>
    <title>EMI Calculation Result</title>
</head>
<body>
    <h1>EMI Calculation Result</h1>
    <p>Principal Amount: <%= principal %></p>
    <p>Rate of Interest: <%= interest %></p>
    <p>Time (in months): <%= time %></p>
    <p>EMI per Month: <%= formattedEmi %></p>
    <p>Total Amount: <%= formattedTotalAmount %></p>
</body>
</html>
