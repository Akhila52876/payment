<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Send Money</title>
    <style>
         body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-image: linear-gradient(45deg, #8b5aed 0%, #78ebfc 100%);
            font-family: Arial, sans-serif;
        }
        .container {
            background: white;
            padding: 50px;
            border-radius: 30px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            width: 450px;
        }
        h2 {
            position: absolute;
            top: 80px;
            font-size: 20px;
            font-weight: bold;
            color: red;
            border: 2px solid red;
            padding: 10px;
            text-align: center;
            background: white;
            width:450px;

        }
        .form-group {
            display: flex;
            align-items: center;
            margin-bottom: 15px;
        }
        label {
            width: 40%;
            font-weight: bold;
            color: blue;
        }
        input {
            width: 60%;
            padding: 8px;
            border: 1px solid blue;
            border-radius: 5px;
        }
        .submit-btn {
            width: 100%;
            background: blue;
            color: white;
            border: none;
            padding: 10px;
            font-size: 16px;
            cursor: pointer;
            border-radius: 5px;
        }
        .submit-btn:hover {
            background: darkblue;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>SEND MONEY</h2>
        <form>
            <div class="form-group">
                <label for="bank">BANK NAME:</label>
                <input type="text" id="bank" name="bank">
            </div>
            <div class="form-group">
                <label for="amount">AMOUNT TO SEND:</label>
                <input type="number" id="amount" name="amount">
            </div>
            <div class="form-group">
                <label for="from">FROM:</label>
                <input type="text" id="from" name="from">
            </div>
            <div class="form-group">
                <label for="account">TO ACCOUNT NUMBER:</label>
                <input type="text" id="account" name="account">
            </div>
            <div class="form-group">
                <label for="wallet">TO WALLET:</label>
                <input type="text" id="wallet" name="wallet">
            </div>
            <button type="submit" class="submit-btn">Submit</button>
        </form>
    </div>
</body>
</html>
