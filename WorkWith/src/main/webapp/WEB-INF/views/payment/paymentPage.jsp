<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<div id=container_paymentPage>

		<span id="paymentRequest_button">결재 요청</span> <span
			id="paymentRequestStatus_button">결재 요청 현황</span> <span
			id="payment_button">결재</span><span id="paymentDetails_button">결재
			내력</span>

		<div id="paymentRequest" style="display: flex">
			<%@ include file="paymentRequest.jsp"%>
		</div>

		<div id="paymentRequestStatus" style="display: none">
			<%@ include file="paymentRequestStatus.jsp"%>
		</div>

		<div id="payment" style="display: none">
			<%@ include file="payment.jsp"%>
		</div>

		<div id="paymentDetails" style="display: none">
			<%@ include file="paymentDetails.jsp"%>
		</div>
	</div>
</body>
</html>