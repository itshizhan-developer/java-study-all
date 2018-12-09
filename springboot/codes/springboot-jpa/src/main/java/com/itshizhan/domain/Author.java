/**
 * Created by leeson8888 on 2018/12/3.
 */
package com.itshizhan.domain;

import lombok.Data;


import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "t_author")
public class Author {

	@Id
	@GeneratedValue
	private Long id;
	private String nickName;
	private String phone;
	private Date signDate;

}
