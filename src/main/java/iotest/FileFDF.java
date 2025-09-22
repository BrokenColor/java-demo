package iotest;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;

import java.io.File;
import java.io.IOException;

/**
 * pdf 处理
 *
 * @author bc
 * @version 1.0
 * createTime 2025/9/22 15:12
 */
public class FileFDF {

    public static void main(String[] args) {
        ;
        // 加载文档
        try (PDDocument document = PDDocument.load(new File("./src/resources/test.pdf"));) {

            // 创建访问权限
            AccessPermission permission = new AccessPermission();
            permission.setReadOnly();
            permission.setCanModify(false);

            // 创建保护策略
            StandardProtectionPolicy spp = new StandardProtectionPolicy("", "", permission);

            // 应用保护策略
            document.protect(spp);

            // 保存文档
            document.save("./src/resources/test_dec.pdf");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (PDDocument document = PDDocument.load(new File("./src/resources/test_dec.pdf"))) {
            document.setAllSecurityToBeRemoved(true);
            PDDocumentInformation info = document.getDocumentInformation();
            info.setTitle("");
            info.setAuthor("author");
            try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
                document.save(outputStream);
            }catch (Exception e){
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
