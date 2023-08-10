package com.lvgu.industrynew.utils;

import com.lvgu.industrynew.entity.SysUserEntity;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 属性工具类
 */
public class BeanUtilss {

    /**
     *实现指定对象的属性设置-保存
     * @param obj
     */
    public static void setBasValue(Object obj, SysUserEntity user){
//        formatString(obj);
        //获得该对象属性的集合
        Field[] fields = obj.getClass().getDeclaredFields();
        //遍历集合
        Date date = new Date();
        for (Field field : fields) {
            try {
                //设置成可访问
                field.setAccessible(true);
                String fileName = field.getName();
                if ("id".equals(fileName)){
                    field.set(obj, UUIDUtil.randomUUID32());
                }
                if ("deleted".equals(fileName)){
                    field.set(obj, 0);
                }
                if (user!=null){
//                    if ("countyCode".equals(fileName)){
//                        if (!CollectionUtils.isEmpty(user.getAreadata()) && user.getAreadata().size()>0){
//                            field.set(obj, user.getAreadata().get(0).getDataid());
//                        }
//                    }
//                    if ("deptId".equals(fileName)){
//                        String deptId = request.getHeader("deptId");
//                        field.set(obj,deptId);
//                    }
                    if ("creator".equals(fileName)){
                        field.set(obj,user.getId());
                    }
                    if ("creater".equals(fileName)){
                        field.set(obj,user.getId());
                    }
                    if ("createrName".equals(fileName)){
                        field.set(obj,user.getUserName());
                    }
                    if ("createName".equals(fileName)){
                        field.set(obj,user.getUserName());
                    }
                    if ("updator".equals(fileName)){
                        field.set(obj,user.getId());
                    }
                    if ("updater".equals(fileName)){
                        field.set(obj,user.getId());
                    }
                    if ("updaterName".equals(fileName)){
                        field.set(obj,user.getUserName());
                    }
                    if ("updateName".equals(fileName)){
                        field.set(obj,user.getUserName());
                    }
                }
                if ("createDate".equals(fileName)){
                    field.set(obj,date);
                }
                if ("updateDate".equals(fileName)){
                    field.set(obj,date);
                }
//                if ("status".equals(fileName)){
//                    field.set(obj,0);
//                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    /**
     *实现指定对象的属性设置-修改
     * @param obj
     */
    public static void updateBasValue(Object obj,SysUserEntity user){
//        formatString(obj);
        //获得该对象属性的集合
        Field[] fields = obj.getClass().getDeclaredFields();
        //遍历集合
        Date date = new Date();
        for (Field field : fields) {
            try {
                //设置成可访问
                field.setAccessible(true);
                String fileName = field.getName();
                if (user!=null){
                    if ("updator".equals(fileName)){
                        field.set(obj,user.getId());
                    }
                    if ("updater".equals(fileName)){
                        field.set(obj,user.getId());
                    }
                    if ("updaterName".equals(fileName)){
                        field.set(obj,user.getUserName());
                    }
                }
                if ("updateDate".equals(fileName)){
                    field.set(obj,date);
                }
//                if ("status".equals(fileName)){
//                    field.set(obj,0);
//                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    /**
     * 实现指定对象的属性设置-保存
     * @param obj	要进行反射操作的实例化对象
     */
    public static void setBasValue1(Object obj, SysUserEntity user) {
        try {
            Field[] fields = obj.getClass().getDeclaredFields();
            if (fields!=null && fields.length>0){
                Date date = new Date();
                for (int i = 0; i <fields.length ; i++) {
                    String fileName = fields[i].getName();
                    if ("id".equals(fileName)){
                        Method setMethod = obj.getClass().getDeclaredMethod("set"+ StringUtilss.initcap(fields[i].getName()), fields[i].getType());
                        setMethod.invoke(obj, UUIDUtil.randomUUID32());//调用setter 方法设置内容
                    }
                    if ("deleted".equals(fileName)){
                        Method setMethod = obj.getClass().getDeclaredMethod("set"+ StringUtilss.initcap(fields[i].getName()), fields[i].getType());
                        setMethod.invoke(obj, 0);//调用setter 方法设置内容
                    }
                    if (user!=null){
//                        if ("countyCode".equals(fileName)){
//                            if (!CollectionUtils.isEmpty(user.getAreadata())){
//                                Method setMethod = obj.getClass().getDeclaredMethod("set"+ StringUtilss.initcap(fields[i].getName()), fields[i].getType());
//                                setMethod.invoke(obj, user.getAreadata().get(0).getDataid());//调用setter 方法设置内容
//                            }
//                        }
//                        if ("deptId".equals(fileName)){
//                            Method setMethod = obj.getClass().getDeclaredMethod("set"+ StringUtilss.initcap(fields[i].getName()), fields[i].getType());
//                            setMethod.invoke(obj, user.getTeamId());//调用setter 方法设置内容
//                        }
                        if ("creator".equals(fileName)){
                            Method setMethod = obj.getClass().getDeclaredMethod("set"+ StringUtilss.initcap(fields[i].getName()), fields[i].getType());
                            setMethod.invoke(obj, user.getId());//调用setter 方法设置内容
                        }
                        if ("createrName".equals(fileName)){
                            Method setMethod = obj.getClass().getDeclaredMethod("set"+ StringUtilss.initcap(fields[i].getName()), fields[i].getType());
                            setMethod.invoke(obj, user.getUserName());//调用setter 方法设置内容
                        }
                        if ("updator".equals(fileName)){
                            Method setMethod = obj.getClass().getDeclaredMethod("set"+ StringUtilss.initcap(fields[i].getName()), fields[i].getType());
                            setMethod.invoke(obj, user.getId());//调用setter 方法设置内容
                        }
                        if ("updaterName".equals(fileName)){
                            Method setMethod = obj.getClass().getDeclaredMethod("set"+ StringUtilss.initcap(fields[i].getName()), fields[i].getType());
                            setMethod.invoke(obj, user.getUserName());//调用setter 方法设置内容
                        }
                    }
                    if ("createDate".equals(fileName)){
                        Method setMethod = obj.getClass().getDeclaredMethod("set"+ StringUtilss.initcap(fields[i].getName()), fields[i].getType());
                        setMethod.invoke(obj, date);//调用setter 方法设置内容
                    }
                    if ("updateDate".equals(fileName)){
                        Method setMethod = obj.getClass().getDeclaredMethod("set"+ StringUtilss.initcap(fields[i].getName()), fields[i].getType());
                        setMethod.invoke(obj, date);//调用setter 方法设置内容
                    }
                    if ("status".equals(fileName)){
                        Method setMethod = obj.getClass().getDeclaredMethod("set"+ StringUtilss.initcap(fields[i].getName()), fields[i].getType());
                        setMethod.invoke(obj, 0);//调用setter 方法设置内容
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 实现指定对象的属性设置-修改
     * @param obj	要进行反射操作的实例化对象
     */
    public static void updateBasValue1(Object obj, SysUserEntity user) {
        try {
            Field[] fields = obj.getClass().getDeclaredFields();
            if (fields!=null && fields.length>0){
                Date date = new Date();
                for (int i = 0; i <fields.length ; i++) {
                    String fileName = fields[i].getName();
                    if (user!=null){
                        if ("updator".equals(fileName)){
                            Method setMethod = obj.getClass().getDeclaredMethod("set"+ StringUtilss.initcap(fields[i].getName()), fields[i].getType());
                            setMethod.invoke(obj, user.getId());//调用setter 方法设置内容
                        }
                        if ("updaterName".equals(fileName)){
                            Method setMethod = obj.getClass().getDeclaredMethod("set"+ StringUtilss.initcap(fields[i].getName()), fields[i].getType());
                            setMethod.invoke(obj, user.getUserName());//调用setter 方法设置内容
                        }
                    }
                    if ("updateDate".equals(fileName)){
                        Method setMethod = obj.getClass().getDeclaredMethod("set"+ StringUtilss.initcap(fields[i].getName()), fields[i].getType());
                        setMethod.invoke(obj, date);//调用setter 方法设置内容
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 实例化对象的创建方法，-保存
     * @param <T>
     * @param clazz 要进行反射实例化的Class类对象，有Class就可以反射实例化对象
     * @param user	要设置给对象的属性内容
     * @return	一个已经配置好属性内容的Java类对象
     */
    public static <T> T create(Class<?> clazz, SysUserEntity user) {
        //如果要想采用反射机型简单Java类对象属性设置的时候，类中必须要有无参构造
        try {
            Object obj = clazz.getDeclaredConstructor().newInstance();
            setBasValue1(obj,user);//通过反射设置属性
            return  (T) obj;//返回对象
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 实例化对象的创建方法，-修改
     * @param <T>
     * @param clazz 要进行反射实例化的Class类对象，有Class就可以反射实例化对象
     * @param user	要设置给对象的属性内容
     * @return	一个已经配置好属性内容的Java类对象
     */
    public static <T> T update(Class<?> clazz, SysUserEntity user) {
        //如果要想采用反射机型简单Java类对象属性设置的时候，类中必须要有无参构造
        try {
            Object obj = clazz.getDeclaredConstructor().newInstance();
            updateBasValue1(obj,user);//通过反射设置属性
            return  (T) obj;//返回对象
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 去掉对象内属性为字符串类型中的空白字符
     * @param obj
     */
    public static void formatString(Object obj){
        //获得该对象属性的集合
        Field[] fields = obj.getClass().getDeclaredFields();
        //定义变量
        String lod_val;
        //遍历集合
        for (Field field : fields) {
            //判断类型是否是string
            if (field.getType() == String.class) {
                try {
                    //设置成可访问
                    field.setAccessible(true);
                    //获得原数据
                    lod_val = (String) field.get(obj);
                    if(StringUtils.isNotBlank(lod_val)) {
                        //去掉空格
                        field.set(obj, replaceSpecialStr(lod_val));
                    }
                } catch (IllegalAccessException ille) {

                }
            }
        }
    }

    /**
     * 对象内数据为空的改成0
     * @param obj
     */
    public static void formatNull(Object obj){
        //获得该对象属性的集合
        Field[] fields = obj.getClass().getDeclaredFields();
        //定义变量
        Object lod_val;
        //遍历集合
        for (Field field : fields) {
            if (field.getType() == Double.class) {
                try {
                    //设置成可访问
                    field.setAccessible(true);
                    //获得原数据
                    lod_val = field.get(obj);
                    if(lod_val == null) {
                        //去掉空格
                        field.set(obj, 0.0);
                    }
                } catch (IllegalAccessException ille) {

                }
            }
            if (field.getType() == BigDecimal.class) {
                try {
                    //设置成可访问
                    field.setAccessible(true);
                    //获得原数据
                    lod_val = field.get(obj);
                    if(lod_val == null) {
                        //去掉空格
                        field.set(obj, BigDecimal.ZERO);
                    }
                } catch (IllegalAccessException ille) {

                }
            }
            if (field.getType() == Integer.class) {
                try {
                    //设置成可访问
                    field.setAccessible(true);
                    //获得原数据
                    lod_val = field.get(obj);
                    if(lod_val == null) {
                        //去掉空格
                        field.set(obj, 0);
                    }
                } catch (IllegalAccessException ille) {

                }
            }
            if (field.getType() == String.class) {
                try {
                    //设置成可访问
                    field.setAccessible(true);
                    //获得原数据
                    lod_val = field.get(obj);
                    if(lod_val == null) {
                        //去掉空格
                        field.set(obj, "");
                    }
                } catch (IllegalAccessException ille) {

                }
            }
        }
    }

    /**
     * 去除字符串中的空格、回车、换行符、制表符等
     * @param str
     * @return
     */
    public static String replaceSpecialStr(String str) {
        if (StringUtils.isNotBlank(str)) {
            str = str.replaceAll("\\s*|\t|\r|\n", "");
        }
        return str;
    }
}
