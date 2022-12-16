package org.WorkWith.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import org.WorkWith.model.PaymentAttachVO;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class PaymentUploadController {
	@RequestMapping(value = "/paymentUpload", method = RequestMethod.GET)
	public void uploaAjax() {
		
	}
	
	@RequestMapping(value = "/paymentUpload", method = RequestMethod.POST)
	public ResponseEntity<ArrayList<PaymentAttachVO>> uploadAjaxAction(MultipartFile[] paymentFile) {
		
		// PaymentAttachVO 클래스 포함
		ArrayList<PaymentAttachVO> list = new ArrayList<>();
		// 폴더 경로
		String uploadFolder = "E:\\01-STUDY\\paymentUpload";
		// 서버 업로드 경로와 getFolder 메서드의 날짜 문자열을 이어서 하나의 폴더 생성
		File uploadPath = new File(uploadFolder, getFolder());
		
		// 폴더 생성(E:\\01-STUDY\\paymentUpload\\현재날짜)
		if(uploadPath.exists() == false) {	// uploadPath가 존재하지 않으면
			uploadPath.mkdirs();
		}
		
		// for(변수명 : 배열명)
		for(MultipartFile multipartFile : paymentFile) {
			// PaymentAttachVO 클래스의 새로운 주소를 반복적으로 생성하여
			// ArrayList에 저장
			PaymentAttachVO attachvo = new PaymentAttachVO();
			
			// 실제 파일명(multipartFile.getOriginalFilename())
			// UUID 적용(UUID_multipartFile.getOriginalFilename());
			UUID uuid = UUID.randomUUID();
			
			// PaymentAttachVO의 uploadPath 변수에 저장()
			attachvo.setUploadPath(getFolder());
			// PaymentAttachVO의 fileName 변수에 저장()
			attachvo.setFileName(multipartFile.getOriginalFilename());
			// PaymentAttachVO의 uuid 변수에 저장()
			attachvo.setUuid(uuid.toString());
			
			// 파일 저장
			//						어느 폴더에,		어떤 파일이름으로
			//					ex)	어느 폴더에(E:\\01-STUDY\\paymentUpload\\현재날짜), 어떤 파일이름으로(UUID_a1.pdf)
			File saveFile = new File(uploadPath, uuid.toString()+"_"+multipartFile.getOriginalFilename());
			
			// 					ex)	E:\\01-STUDY\\paymentUpload\\a1.jpg에 파일을 전송(transferTo)
			try {	// transferTo() 메서드에 예외가 있으면
			    multipartFile.transferTo(saveFile);	// 서버로 원본파일 전송
			    //  PaymentAttachVO에 저장 된 데이터를 배열에 추가(add 메서드)
			    list.add(attachvo); 
			} catch(Exception e) {	//예외를 처리하라.
				System.out.println(e.getMessage());
			}
		}	// for문 끝
		return new ResponseEntity<>(list, HttpStatus.OK);

	}
	
	// 다운로드 주소 생성
	@RequestMapping(value = "/paymentDownload", method = RequestMethod.GET)
	public ResponseEntity<Resource> downloadFile(String fileName){
		
		Resource resource = new FileSystemResource("E:\\01-STUDY\\paymentUpload\\"+fileName);
		
		// 다운로드 시 파일의 이름을 처리
		String resourceName = resource.getFilename();
		
		HttpHeaders headers = new HttpHeaders();
		
		try {
			// 다운로드 파일이름이 한글일 때, 깨지지 않게 하기 위한 설정
			headers.add("Content-Disposition", "attachment;filename=" + new String(resourceName.getBytes("utf-8"), "ISO-8859-1"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(resource, headers, HttpStatus.OK);
	}

	// 년/ 월/ 일 폴더 생성하는 메서드 선언
	private String getFolder() {
		
		// 현재날짜 추출(Wed Aug 24 09:23:12 KST 2022)
		Date date = new Date();
		// Wed Aug 24 09:23:12 KST 2022 -> 2022-08-24
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// 현재날짜와 날짜형식을 연결.
		String str = sdf.format(date);	// 2022-08-24
		// 2022-08-24 -> 2022\08\24로 변경 ->  str.replace("-", "\\")
				
		return str.replace("-", "\\");
	}

}
