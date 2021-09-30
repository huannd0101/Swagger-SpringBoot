# Demo Swagger
<hr>


## Add dependence:
<pre>&lt;<span class="pl-ent">dependency</span>&gt;
  &lt;<span class="pl-ent">groupId</span>&gt;io.springfox&lt;/<span class="pl-ent">groupId</span>&gt;
  &lt;<span class="pl-ent">artifactId</span>&gt;springfox-swagger2&lt;/<span class="pl-ent">artifactId</span>&gt;
  &lt;<span class="pl-ent">version</span>&gt;2.9.2&lt;/<span class="pl-ent">version</span>&gt;
&lt;/<span class="pl-ent">dependency</span>&gt;
</pre>
<pre>&lt;<span class="pl-ent">dependency</span>&gt;
  &lt;<span class="pl-ent">groupId</span>&gt;io.springfox&lt;/<span class="pl-ent">groupId</span>&gt;
  &lt;<span class="pl-ent">artifactId</span>&gt;springfox-swagger-ui&lt;/<span class="pl-ent">artifactId</span>&gt;
  &lt;<span class="pl-ent">version</span>&gt;2.9.2&lt;/<span class="pl-ent">version</span>&gt;
&lt;/<span class="pl-ent">dependency</span>&gt;
</pre>

## Lý thuyết:

- springfox: là một thư viện java implementation của Swagger Specification.

- springfox-swagger2: chứa core của swagger, giúp chúng ta khai báo document cho api.

- springfox-swagger-ui: giúp chúng ta biểu diễn tài liệu dưới dạng web view, dễ nhìn và test.

<table>
    <thead>
        <tr>
            <th>Syntax</th>
            <th>Description</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>@Api</td>
            <td>Đánh dấu 1 class là nơi chứa các API</td>
        </tr>
        <tr>
            <td>@ApiModel</td>
            <td>Đánh dấu 1 class là Swagger Model</td>
        </tr>
        <tr>
            <td>@ApiModelProperty</td>
            <td>Bổ sung các thông tin cho</td>
        </tr>
        <tr>
            <td>@ApiOperation</td>
            <td>Mô tả cho một API và response của nó</td>
        </tr>
        <tr>
            <td>@ApiParam</td>
            <td>Mô tả các parameter</td>
        </tr>
        <tr>
            <td>@ApiResponse</td>
            <td>Mô tả status code của response</td>
        </tr>
        <tr>
            <td>@ApiResponses</td>
            <td>Mô tả danh sách các status code của response</td>
        </tr>
    </tbody>
</table>

##  Config Swagger:

- Đối tượng Docket của Swagger và nó sẽ quét hết các địa chỉ API mà bạn chỉ định, rồi tự động sinh ra tài liệu cơ bản cho chúng ta.

<pre>
@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
            .apis(RequestHandlerSelectors.basePackage("com.example.swagger.controller"))
            .paths(PathSelectors.regex("/.*"))
            .build()
            .apiInfo(apiEndPointsInfo());
    }

    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title("Spring Boot REST API")
            .description("Employee Management REST API")
            .contact(new Contact("Huân", "...", "huannd0101@gmail.com"))
            .license("Apache 2.0")
            .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
            .version("1.0.0")
            .build();
    }
}
</pre>

1. Để Swagger hoạt động thì cần annotation @EnableSwagger2
2. Chọn nơi chứa API bằng RequestHandlerSelectors, để quét cả project thì dùng RequestHandlerSelectors.any()
3. Chỉ định bộ lọc cho các API bằng PathSelectors, để quét tất cả dùng PathSelectors.any()

## Sử dụng:

- Sau khi config xong thì truy cập vào: http://localhost:8080/swagger-ui.html thì sẽ thấy document.
- Các cái còn lại đọc code trong controller nhé :v

