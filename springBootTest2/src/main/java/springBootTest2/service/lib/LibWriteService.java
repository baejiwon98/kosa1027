package springBootTest2.service.lib;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import springBootTest2.command.LibCommand;
import springBootTest2.domain.AuthInfo;
import springBootTest2.domain.LibDTO;
import springBootTest2.mapper.LibMapper;

@Component
@Service
public class LibWriteService {
	@Autowired
	LibMapper libMapper;
	public void execute(LibCommand libCommand, HttpServletRequest request) {
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		LibDTO dto = new LibDTO();
		dto.setLibWriter(libCommand.getLibWriter());
		dto.setLibSubject(libCommand.getLibSubject());
		dto.setLibContent(libCommand.getLibContent());
		dto.setIpAddr(request.getRemoteAddr());
		dto.setLibPw(libCommand.getLibPw());
		dto.setMemId(authInfo.getUserId());
		
		// 파일 정보를 입력하기 위한 변수
		String originalTotal = "";
		String storeTotal = "";
		String fileSizeTotal = "";
		String fileDir = "/view/lib";
		String filePath = request.getServletContext().getRealPath(fileDir);
		if(!libCommand.getReport()[0].getOriginalFilename().isEmpty()) {
			for(MultipartFile mf : libCommand.getReport() ) {
				String originalFile = mf.getOriginalFilename();
				String extension = originalFile.substring(originalFile.lastIndexOf("."));
				String storeName = UUID.randomUUID().toString().replace("-", "");
				String storeFileName = storeName + extension;
				String fileSize = Long.toString(mf.getSize());
				originalTotal += originalFile + "`";
				storeTotal += storeFileName + "`";
				fileSizeTotal += fileSize+ "`";
				File file = new File(filePath + "/" + storeFileName);
				try {
					mf.transferTo(file);
				} catch (Exception e) { e.printStackTrace(); }
			}
		}
			dto.setFileSize(fileSizeTotal);
			dto.setOriginalFileName(originalTotal);
			dto.setStoreFileName(storeTotal);
			libMapper.libInsert(dto);	
	}
}
