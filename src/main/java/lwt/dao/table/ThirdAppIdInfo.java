package lwt.dao.table;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;

@Data
@Builder
@TableName(value = "third_app_secert_info")
public class ThirdAppIdInfo {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("appName")
    private String appName;

    @TableField("appNumber")
    private String appNumber;

    @TableField("appId")
    private String appId;

    @TableField("appSecert")
    private String appSecert;

    @TableField(value = "createDate", jdbcType = JdbcType.TIMESTAMP)
    private Date createDate;

    @TableField("redirectUrl")
    private String redirectUrl;

    @TableField("isdelete")
    private Integer isdelete;

}
