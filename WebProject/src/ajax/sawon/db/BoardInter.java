package ajax.sawon.db;

import java.util.List;

public interface BoardInter {
	public void dataInsert(SawonDto dto);
	public List<SawonDto> getAllDatas();
	public void dataDelete(String name);
}
