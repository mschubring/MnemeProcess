package inc.troll.mnemeprocess.data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "networks")
public class Network extends BaseEntity {

	private String macAddress;
	
}
