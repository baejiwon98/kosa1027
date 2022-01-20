package springBootTest2.service.lib;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import springBootTest2.command.LibCommand;
import springBootTest2.domain.AuthInfo;
import springBootTest2.domain.LibDTO;
import springBootTest2.mapper.LibMapper;

@Component
@Service
public class LibUpdateService {
	@Autowired
	LibMapper libMapper;
	public String execute(LibCommand libCommand, HttpSession session, Model model) {
		String path = "redirect:libDetail?num="+libCommand.getLibNum();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		LibDTO dto = libMapper.selectOne(libCommand.getLibNum());
		
		String originalTotal = "";
		String storeTotal = "";
		String fileSizeTotal ="";
		
		String [] fileNames = null;
		if(dto.getStoreFileName() != null) {
			fileNames = dto.getStoreFileName().split("`");
		}
		
		String filePath = "/view/lib";
		String fileDir = session.getServletContext().getRealPath(filePath);
		
		if(!dto.getLibPw().equals(libCommand.getLibPw()) || 
				!dto.getMemId().equals(authInfo.getUserId())) {
			model.addAttribute("dto", libCommand);
			model.addAttribute("err_pw","비밀번호가 틀리거나 작성자가 아닙니다.");
			path = "thymeleaf/lib/libModify";
		}else {
			dto.setLibContent(libCommand.getLibContent());
			dto.setLibNum(libCommand.getLibNum());
			dto.setLibSubject(libCommand.getLibSubject());
			dto.setLibWriter(libCommand.getLibWriter());
			
			if(dto.getOriginalFileName() != null) {
				originalTotal = dto.getOriginalFileName();
				storeTotal = dto.getStoreFileName();
				fileSizeTotal = dto.getFileSize();
			}
						
			if(!libCommand.getReport()[0].getOriginalFilename().isEmpty()) {
				originalTotal = "";
				storeTotal = "";
				fileSizeTotal ="";
				
				for(MultipartFile mf : libCommand.getReport()) {
					String originalFile = mf.getOriginalFilename();
					String extension = originalFile.substring(originalFile.lastIndexOf("."));
					String storeName = UUID.randomUUID().toString().replace("-", "");
					String storeFileName = storeName + extension;
					String fileSize = Long.toString(mf.getSize());
					
					File file = new File(fileDir + "/" + storeFileName);
					try {
						mf.transferTo(file);
					}catch(Exception e) {}
					originalTotal += originalFile + "`";
					storeTotal += storeFileName + "`";
					fileSizeTotal += fileSize + "`";
				}
			}
			
			dto.setFileSize(fileSizeTotal);
			dto.setOriginalFileName(originalTotal);
			dto.setStoreFileName(storeTotal);
			Integer i = libMapper.libUpdate(dto);
			if(!libCommand.getReport()[0].getOriginalFilename().isEmpty()){
				if(i > 0) {
					File file = null;
					try {
						for(String fileName : fileNames) {
							file = new File(fileDir + "/" + fileName);
							if(file.exists()) file.delete();
						}
					}catch(Exception e) {}
				}
			}
		}
		return path;
	}
}