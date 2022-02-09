package springBootTest2.service.emplib;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import springBootTest2.command.EmpLibCommand;
import springBootTest2.domain.AuthInfo;
import springBootTest2.domain.EmpLibDTO;
import springBootTest2.mapper.EmpLibMapper;

@Component
@Service
public class EmpLibWriteService {
	@Autowired
	EmpLibMapper empLibMapper;
	public void execute(EmpLibCommand empLibCommand, HttpServletRequest request) {
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");	
		
		EmpLibDTO dto = new EmpLibDTO();
		
		dto.setEmpId(authInfo.getUserId());
		
		dto.setEmpNum(empLibMapper.empnumGenerate(dto));
		dto.setLibWriter(empLibCommand.getLibWriter());
		dto.setLibSubject(empLibCommand.getLibSubject());
		dto.setLibContent(empLibCommand.getLibContent());
		dto.setLibPw(empLibCommand.getLibPw());
		dto.setIpAddr(request.getRemoteAddr());
		
		// 파일 정보를 입력하기 위한 변수
		String originalTotal = "";
		String storeTotal = "";
		String fileSizeTotal = "";
		String path = "/view/empLib";
		String fileDir = request.getServletContext().getRealPath(path);		
//		String fileDir = "C:\Users\ user\workspace\eclipse-workspace\springBootTest2\src\main\webapp\view\empLib" 		
		System.out.println(fileDir);
		
		for(MultipartFile mf : empLibCommand.getReport()) {
		 	String original = mf.getOriginalFilename();
			String extension = original.substring(original.lastIndexOf("."));
			// 중복 파일명이 있을 때를 대비하여 유일한 이름의 파일명을 생성
			String store = UUID.randomUUID().toString().replace("-", "");
			String storeFileName = store + extension;
			File file = new File (fileDir + "/" + storeFileName);
			String fileSize = Long.toString(mf.getSize());
			try {
				mf.transferTo(file);
			}catch(Exception e) {e.printStackTrace();}
			originalTotal += original + "`";
			storeTotal += storeFileName + "`";
			fileSizeTotal += fileSize + "`";
		}
		dto.setFileSize(fileSizeTotal);
		dto.setOriginalFileName(originalTotal);
		dto.setStoreFileName(storeTotal);
		empLibMapper.empLibInsert(dto);
		
	}
}
