<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Calculate Bill</title>
    <style>

             .form-container {
                        min-height: calc(100vh - 60px); /* Assuming navbar is ~60px tall */
                        display: flex;
                        justify-content: center;
                        align-items: center;
                        padding-top: 40px;
                        padding-bottom: 40px;
                        background-color: #f2f2f2;
                    }

            /* Style the form box */
            form {

                        padding: 60px 40px;
                        border-radius: 60px;
                        border-top: 5px solid blue; /* Top border added */
                        box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
                        font-family: Arial, sans-serif;
                        width: 400px; /* optional: fixed width */
                        margin: auto ;
                    }

            /* Label styling */
            label {
                font-weight: bold;
            }

            /* Input field styling */
            input[type="text"] {
                width: 100%;
                padding: 8px 10px;
                margin-top: 5px;
                margin-bottom: 15px;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
            }

            /* Submit button styling */
            input[type="submit"] {
                width: 100%;
                background-color: blue;
                color: white;
                padding: 10px;
                border: none;
                border-radius: 5px;
                font-size: 16px;
                cursor: pointer;
            }

            input[type="submit"]:hover {
                background-color: #45a049;
            }


        </style>
    <script src="https://cdn.tailwindcss.com"></script>


</head>
<body>
    <%@ include file ="/WEB-INF/views/navBar.jsp"%>

    <div class="form-container">
            <form action="${pageContext.request.contextPath}/customer" method="post">
            <h1 class ="text-4xl font-bold mb-8 text-center text-navy-800">Enter Customer Details</h1>



                <label for="customerName">Customer Name:</label><br>
                <input type="text" id="customerName" name="customerName" required><br>

                <label for="houseNumber">House Number:</label><br>
                <input type="text" id="houseNumber" name="houseNumber" required><br>

                <label for="unitsConsumed">Units Consumed:</label><br>
                <input type="text" id="unitsConsumed" name="unitsConsumed" required><br>

                <input type="submit" value="Submit">
            </form>
        </div>

</body>
</html>
