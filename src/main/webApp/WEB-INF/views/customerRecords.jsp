<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>$</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
<%@ include file ="/WEB-INF/views/navBar.jsp"%>
<div class="max-w-6xl mx-auto px-6 py-8">
    <h1 class="text-4xl font-bold mb-8 text-center text-navy-800">All Customer details</h1>
    <table class="table-auto w-full border-collapse border border-gray-400 text-center text-lg">
        <thead>
            <tr class="bg-blue-900 text-white">
                <th class="border px-4 py-2">ID</th>
                <th class="border px-4 py-2">Customer Name</th>
                <th class="border px-4 py-2">House Number</th>
                <th class="border px-4 py-2">Units Consumed</th>

            </tr>
        </thead>
        <tbody>
            <c:forEach var="customer" items="${customer}">
                <tr class="text-gray-800">
                    <td class="border px-4 py-2">${customer.customerId}</td>
                    <td class="border px-4 py-2">${customer.customerName}</td>
                    <td class="border px-4 py-2">${customer.houseNumber}</td>
                    <td class="border px-4 py-2">${customer.unitsConsumed}</td>

                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>


</body>
</html>
