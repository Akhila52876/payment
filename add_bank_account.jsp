<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Bank Account</title>
    <style>
       body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-image: linear-gradient(45deg, #8b5aed 0%, #78ebfc 100%);
            font-family: Arial, sans-serif;
        }

               .title {
            position: absolute;
            top: 20px;
            font-size: 20px;
            font-weight: bold;
            color: red;
            border: 2px solid red;
            padding: 10px;
            text-align: center;
            background: white;
            width:450px;
        }

        .form-container {
            background: white;
            padding: 50px;
            border-radius: 30px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            width: 450px;
        }
        label {
            font-weight: bold;
            color: blue;
            
            width: 150px;
        }

         .input-group {
            margin-bottom: 15px;
        }
         .input-group input {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            transition: border-color 0.3s, box-shadow 0.3s;
        }
        .input-group input:hover, .input-group input:focus {
            border-color: #8b5aed;
            box-shadow: 0px 0px 8px rgba(139, 90, 237, 0.5);
            outline: none;
        }
         .submit-btn {
            background-color: blue;
            color: white;
            padding: 8px 15px;
            border: none;
            cursor: pointer;
            font-size: 16px;
        }

        .submit-btn:hover {
            background-color: darkblue;
        }
    </style>
</head>
<body>
   
    <div class="title">Add Bank Account</div>
 
    <div class="form-container">
        <form action="submit_account.jsp" method="post">
             <div class="input-group">
            <label>BANK NAME:</label> <input type="text" name="bank_name" required><br>
            <br>
            
            <label>ACCOUNT NUMBER:</label> <input type="text" name="account_number" required><br> <br>
            <label>ACCOUNT TYPE:</label> <input type="text" name="account_type" required><br> <br>
            <label>IFSC CODE:</label> <input type="text" name="ifsc_code" required><br> <br>
            <label>CURRENT BALANCE:</label> <input type="number" name="balance" required><br> <br>
            <label>PIN:</label> <input type="password" name="pin" required><br> <br>
            </div>   
            <center><button type="submit" class="submit-btn">Submit</button></center>
        </form>
    </div>

</body>
</html>
