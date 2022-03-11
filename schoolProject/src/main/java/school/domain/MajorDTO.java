package school.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("MajorDTO")
public class MajorDTO {
	String departmentNum;
	String departmentName;
	String departmentPhone;
	String departmentAddr;
	
	String zip;
	String fullAddr;
	String addr1;
	String addr2;
	String detailAddr;
}
