<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <title>Form Đăng Ký Khóa Học Cho Sinh Viên</title>
    <style>

        body {
            font-family: Arial, sans-serif;
	        background-color: rgb(136,136,136);
	        margin: 0;
        }

        .wrapper {
            margin: auto;
            width: 60%;
            margin-top: 20px;
            border-radius: 10px;
            box-shadow: 3px 3px 3px rgba(0, 0, 0, 0.1), 
            -3px -3px 3px rgba(0, 0, 0, 0.1), 
            3px -3px 3px rgba(0, 0, 0, 0.1), 
            -3px 3px 3px rgba(0, 0, 0, 0.1);
        }
    </style>
</head>
<body>
    <div class="wrapper border p-3">
        <form action="formController" method="post">

            <div class="row  text-white">
                <div class="col-sm-2">
                    First name
                </div>
                <div class="col-sm-4">
                    <input type="text" name="firstName" class="form-control">
                </div>
                <div class="col-sm-4">
                    (max 30 characters A-Z and a-z)
                </div>
            </div>

            <div class="row mt-4 text-white">
                <div class="col-sm-2">
                    Last name
                </div>
                <div class="col-sm-4">
                    <input type="text" name="lastName" class="form-control">
                </div>
                <div class="col-sm-4">
                    (max 30 characters A-Z and a-z)
                </div>
            </div>

            <div class="row mt-4">
                <div class="col-sm-2 text-white">
                    Date of Birth
                </div>
                <div class="col-sm-2">
                    <select name="month" class="form-control">
                        <option value="0">Month</option>
                        <option value="01">Tháng 1</option>
                        <option value="02">Tháng 2</option>
                        <option value="03">Tháng 3</option>
                        <option value="04">Tháng 4</option>
                        <option value="05">Tháng 5</option>
                        <option value="06">Tháng 6</option>
                        <option value="07">Tháng 7</option>
                        <option value="08">Tháng 8</option>
                        <option value="09">Tháng 9</option>
                        <option value="10">Tháng 10</option>
                        <option value="11">Tháng 11</option>
                        <option value="12">Tháng 12</option>
                    </select>
                </div>
                <div class="col-sm-2">
                    <select name="day" class="form-control">
                        <option value="0">Day</option>
                        <option value="01">01</option>
                        <option value="02">02</option>
                        <option value="03">03</option>
                        <option value="04">04</option>
                        <option value="05">05</option>
                        <option value="06">06</option>
                        <option value="07">07</option>
                        <option value="08">08</option>
                        <option value="09">09</option>
                        <option value="10">10</option>
                        <option value="11">11</option>
                        <option value="12">12</option>
                        <option value="13">13</option>
                        <option value="14">14</option>
                        <option value="15">15</option>
                        <option value="16">16</option>
                        <option value="17">17</option>
                        <option value="18">18</option>
                        <option value="19">19</option>
                        <option value="20">20</option>
                        <option value="21">21</option>
                        <option value="22">22</option>
                        <option value="23">23</option>
                        <option value="24">24</option>
                        <option value="25">25</option>
                        <option value="26">26</option>
                        <option value="27">27</option>
                        <option value="28">28</option>
                        <option value="29">29</option>
                        <option value="30">30</option>
                        <option value="31">31</option>
                    </select>
                </div>
                <div class="col-sm-2">
                    <select name="year" class="form-control">
                        <option value="0">Year</option>
                        <option value="2024">2024</option>
                        <option value="2023">2023</option>
                        <option value="2022">2022</option>
                        <option value="2021">2021</option>
                        <option value="2020">2020</option>
                        <option value="2019">2019</option>
                        <option value="2018">2018</option>
                        <option value="2017">2017</option>
                        <option value="2016">2016</option>
                        <option value="2015">2015</option>
                        <option value="2014">2014</option>
                        <option value="2013">2013</option>
                        <option value="2012">2012</option>
                        <option value="2011">2011</option>
                        <option value="2010">2010</option>
                        <option value="2009">2009</option>
                        <option value="2008">2008</option>
                        <option value="2007">2007</option>
                        <option value="2006">2006</option>
                        <option value="2005">2005</option>
                        <option value="2004">2004</option>
                        <option value="2003">2003</option>
                        <option value="2002">2002</option>
                        <option value="2001">2001</option>
                        <option value="2000">2000</option>
                    </select>
                </div>
            </div>

            <div class="row mt-4 text-white">
                <div class="col-sm-2">
                    Email
                </div>
                <div class="col-sm-4">
                    <input type="email" name="email" class="form-control">
                </div>              
            </div>

            <div class="row mt-4 text-white">
                <div class="col-sm-2">
                    Mobile Number
                </div>
                <div class="col-sm-4">
                    <input type="tel" name="phone" class="form-control">
                </div>   
                <div class="col-sm-4">
                    (10 digit number)
                </div>             
            </div>

            <div class="row mt-4 text-white">
                <div class="col-sm-2">
                    Gender
                </div>
                <div class="col-sm-5 d-flex">
                   <div class="form-check">
                        <input class="form-check-input" type="radio" name="gender" id="female" value="female" checked="checked">
                        <label class="form-check-label" for="female">Female</label>
                    </div>
                    <div class="form-check mx-4">
                        <input class="form-check-input" type="radio" name="gender" id="male" value="male">
                        <label class="form-check-label" for="male">Male</label>
                    </div>
                </div>       
            </div>

            <div class="row mt-4 text-white">
                <div class="col-sm-2 d-flex align-items-center">
                    Address
                </div>
                <div class="col-sm-4">
                    <Textarea class="form-control" name="address"></Textarea>
                </div>             
            </div>

            <div class="row mt-4 text-white">
                <div class="col-sm-2">
                    City
                </div>
                <div class="col-sm-4">
                    <input type="text" name="City" class="form-control">
                </div>
                <div class="col-sm-4">
                    (max 30 characters A-Z and a-z)
                </div>
            </div>

            <div class="row mt-4 text-white">
                <div class="col-sm-2">
                    Pin Code
                </div>
                <div class="col-sm-4">
                    <input type="text" name="pinCode" class="form-control">
                </div>   
                <div class="col-sm-4">
                    (6 digit number)
                </div>             
            </div>

            <div class="row mt-4 text-white">
                <div class="col-sm-2">
                    State
                </div>
                <div class="col-sm-4">
                    <input type="text" name="state" class="form-control">
                </div>
                <div class="col-sm-4">
                    (max 30 characters A-Z and a-z)
                </div>
            </div>

            <div class="row mt-4">
                <div class="col-sm-2 text-white">
                    Country
                </div>
                <div class="col-sm-2">
                    <select name="country" class="form-control">
                        <option value="1">India</option>
                        <option value="2">Japan</option>
                        <option value="3">America</option>
                        <option value="4">China</option>
                        <option value="5">VietNam</option>
                    </select>
                </div>
            </div>

            <div class="row mt-4 text-white">
                <div class="col-sm-2">
                    Hobbies
                </div>
                <div class="col-sm-10 d-flex">
                    
                    <div class="form-check">
                        <label class="form-check-label" for="hobbies">Drawing</label>
                        <input class="form-check-input" type="checkbox" name="hobbies" value="drawing" checked="checked">
                    </div>
                    <div class="form-check mx-2">
                        <label class="form-check-label" for="hobbies">Singing</label>
                        <input class="form-check-input" type="checkbox" name="hobbies" value="singing">
                    </div>
                    <div class="form-check">
                        <label class="form-check-label" for="hobbies">Dancing</label>
                        <input class="form-check-input" type="checkbox" name="hobbies" value="dancing">
                    </div>
                    <div class="form-check mx-2">
                        <label class="form-check-label" for="hobbies">Sketching</label>
                        <input class="form-check-input" type="checkbox" name="hobbies" value="sketching">
                    </div>
                    <div class="form-check">
                        <label class="form-check-label" for="hobbies">Others</label>
                        <input class="form-check-input" type="checkbox" name="hobbies" value="others">
                        <input type="text">
                    </div>
                </div>       
            </div>

            <div class="row mt-4 text-white">
                <div class="col-sm-2 d-flex align-items-center">
                    Qualification
                </div>
                <div class="col-sm-10 border">
                    <div class="row text-center">
                        <div class="col-sm-1 p-1">Sl.No.</div>
                        <div class="col-sm-2 p-1">Examination</div>
                        <div class="col-sm-3 p-1">Board</div>
                        <div class="col-sm-3 p-1">Percentage</div>
                        <div class="col-sm-3 p-1">Year of Passing</div>
                    </div>
                    <div class="row text-center">
                        <div class="col-sm-1 p-1">1</div>
                        <div class="col-sm-2 p-1">Class X</div>
                        <div class="col-sm-3 p-1"><input type="text" name="classX-board" class="form-control text-center"></div>
                        <div class="col-sm-3 p-1"><input type="text" name="classX-percentage" class="form-control text-center"></div>
                        <div class="col-sm-3 p-1"><input type="text" name="classX-year" class="form-control text-center"></div>
                    </div>
                    <div class="row text-center">
                        <div class="col-sm-1 p-1">2</div>
                        <div class="col-sm-2 p-1">Class XII</div>
                        <div class="col-sm-3 p-1"><input type="text" name="classXII-board" class="form-control text-center"></div>
                        <div class="col-sm-3 p-1"><input type="text" name="classXII-percentage" class="form-control text-center"></div>
                        <div class="col-sm-3 p-1"><input type="text" name="classXII-year" class="form-control text-center"></div>
                    </div>
                    <div class="row text-center">
                        <div class="col-sm-1 p-1">3</div>
                        <div class="col-sm-2 p-1">Graduation</div>
                        <div class="col-sm-3 p-1"><input type="text" name="graduation-board" class="form-control text-center"></div>
                        <div class="col-sm-3 p-1"><input type="text" name="graduation-percentage" class="form-control text-center"></div>
                        <div class="col-sm-3 p-1"><input type="text" name="graduation-year" class="form-control text-center"></div>
                    </div>
                    <div class="row text-center">
                        <div class="col-sm-1 p-1">4</div>
                        <div class="col-sm-2 p-1">Masters</div>
                        <div class="col-sm-3 p-1"><input type="text" name="masters-board" class="form-control text-center"></div>
                        <div class="col-sm-3 p-1"><input type="text" name="masters-percentage" class="form-control text-center"></div>
                        <div class="col-sm-3 p-1"><input type="text" name="masters-year" class="form-control text-center"></div>
                    </div>
                    <div class="row text-center">
                        <div class="col-sm-1 p-1"></div>
                        <div class="col-sm-2 p-1"></div>
                        <div class="col-sm-3 p-1">(10 char max)</div>
                        <div class="col-sm-3 p-1">(upto 2 decimal)</div>
                        <div class="col-sm-3 p-1"></div>
                    </div>
                </div>
            </div>

            <div class="row mt-4 text-white">
                <div class="col-sm-3">
                    Course applies for
                </div>
                <div class="col-sm-5 d-flex">
                    <div class="form-check">
                         <input class="form-check-input" type="radio" name="course" value="BCA" checked="checked">
                         <label class="form-check-label">BCA</label>
                     </div>
                     <div class="form-check mx-3">
                        <input class="form-check-input" type="radio" name="course" value="BCOM">
                        <label class="form-check-label">B.Com</label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="course" value="BSC">
                        <label class="form-check-label">B.Sc</label>
                    </div>
                    <div class="form-check mx-3">
                        <input class="form-check-input" type="radio" name="course" value="BA">
                        <label class="form-check-label">B.A</label>
                    </div>
                 </div>               
            </div>

            <div class="row mt-4 text-white">
                <div class="col-sm-4"></div>
                <div class="col-sm-4">
                    <button type="submit">Submit</button>
                    <button type="reset">Reset</button>
                </div>
                <div class="col-sm-4"></div>
            </div>

        </form>
    </div>
</body>
</html>