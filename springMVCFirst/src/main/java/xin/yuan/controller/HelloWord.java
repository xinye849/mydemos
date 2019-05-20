package xin.yuan.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.net.httpserver.Authenticator;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import xin.yuan.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;

/**
 * @authorknightx
 * @create2019/4/12
 * @since 1.0.0
 */
@Controller
public class HelloWord {
    @RequestMapping(path = "/hello")
    public String sayHello(){
        System.out.println("hello springMVC");
        return "aaa";
    }

    /**
    *@method:testParams
     * 请求参数的绑定
    *@return:aaa
    *@since: 1.0.0
    *@Author:knightx
    *@Date:2019/4/13
    */
    @RequestMapping("/testParame")
    public String testParams(String username,String pswd){
        System.out.println(username+"===="+pswd);
        return "aaa";
    }
    @RequestMapping("/user")
    public String testUser(User user){

        System.out.println(user);
        return "aaa";
    }
    /**
    *@method:
    *@return:
     * 获取原生servlet
    *@since: 1.0.0
    *@Author:knightx
    *@Date:2019/4/14
    */
    @RequestMapping("/testServlet")
    public String testServlet(HttpServletRequest request, HttpServletResponse response){

        return null;
    }

    /**
    *@method:
    *@return:
     * 传统文件上传
    *@since: 1.0.0
    *@Author:knightx
    *@Date:2019/4/15
    */
@RequestMapping("/fileupload1")
    public String fileUpload1(HttpServletRequest request,HttpServletResponse response) throws Exception {
    System.out.println("文件开始上传");
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        File file = new File(path);
        if(!file.exists()){
            file.mkdir();
        }
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload fileUpload = new ServletFileUpload(factory);
        List<FileItem> fileItems = fileUpload.parseRequest(request);
        for (FileItem item : fileItems){
            if(item.isFormField()){

            }else {
                String itemName = item.getName();
                item.write(new File(path,itemName));
            }
        }

    return "aaa";
    }


    /**
     *@method:
     *@return:
     * springmvc文件上传
     *@since: 1.0.0
     *@Author:knightx
     *@Date:2019/4/15
     */
    @RequestMapping("/fileupload2")
    public String fileUpload2(HttpServletRequest request) throws Exception {
        System.out.println("文件开始上传");
        MultipartHttpServletRequest mreq = (MultipartHttpServletRequest) request;
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        File file = new File(path);
        if(!file.exists()){
            file.mkdir();
        }
        String uname = mreq.getParameter("uname");
        System.out.println(uname);
        MultipartFile file1 = mreq.getFile("file");
        String originalFilename = file1.getOriginalFilename();
        file1.transferTo(new File(path,originalFilename));


        return "aaa";
    }


    /**
     *@method:
     *@return:
     * springmvc跨服务器文件上传
     *@since: 1.0.0
     *@Author:knightx
     *@Date:2019/4/15
     */
    @RequestMapping("/fileupload3")
    public String fileUpload3(HttpServletRequest request) throws Exception {
        System.out.println("跨服务器文件开始上传");
        MultipartHttpServletRequest mreq = (MultipartHttpServletRequest) request;

        //上传文件服务器路径
        String path = "http://localhost:9090/fileUpload/uploads/";
        MultipartFile file = mreq.getFile("file");
        String originalFilename = file.getOriginalFilename();
        //创建客户端对象
        Client client = Client.create();
        //客户端和文件服务器进行连接
        WebResource webResource = client.resource(path + originalFilename);
        webResource.put(file.getBytes());


        return "aaa";
    }


    @RequestMapping("/testException")
    public String testException(){
        int a = 10;
        int b = a/0;
        return null;
    }
}
