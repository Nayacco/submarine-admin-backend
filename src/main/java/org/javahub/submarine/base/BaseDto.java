package org.javahub.submarine.base;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.javahub.submarine.common.constant.GlobalConst;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @JsonSerialize(using= ToStringSerializer.class)
    private Long id;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 逻辑删除（0未删除，1已删除）
     */
    private Integer delFlag = GlobalConst.UNDEL_FLAG;

    protected <T> T copyProperties(Class<T> target) {
        // 如果自身实现了toDto方法，则调用
//        try {
//            Method toEntity = this.getClass().getMethod("toEntity");
//            toEntity.setAccessible(true);
//            return (T)toEntity.invoke(this);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        // 自身没有toDto，则浅拷贝
        try {
            T targetInstance = target.newInstance();
            BeanUtils.copyProperties(this, targetInstance);
            return targetInstance;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
