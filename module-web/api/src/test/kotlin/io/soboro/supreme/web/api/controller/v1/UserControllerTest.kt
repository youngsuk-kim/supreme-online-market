package io.soboro.supreme.web.api.controller.v1

import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.runs
import io.restassured.http.ContentType
import io.soboro.supreme.core.application.LoginService
import io.soboro.supreme.core.application.RegisterService
import io.soboro.supreme.web.api.RestDocsTest
import io.soboro.supreme.web.api.RestDocsUtils.requestPreprocessor
import io.soboro.supreme.web.api.RestDocsUtils.responsePreprocessor
import io.soboro.supreme.web.api.support.security.JwtProcessor
import io.soboro.supreme.web.api.web.controller.v1.UserController
import io.soboro.supreme.web.api.web.controller.v1.request.UserRegisterRequest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
import org.springframework.restdocs.payload.JsonFieldType
import org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath
import org.springframework.restdocs.payload.PayloadDocumentation.responseFields

class UserControllerTest : RestDocsTest() {
    private lateinit var registerService: RegisterService
    private lateinit var loginService: LoginService
    private lateinit var jwtProcessor: JwtProcessor
    private lateinit var controller: UserController

    @BeforeEach
    fun setUp() {
        registerService = mockk()
        loginService = mockk()
        jwtProcessor = mockk()
        controller = UserController(registerService, loginService, jwtProcessor)
        mockMvc = mockController(controller)
    }

    @Test
    fun `user register api`() {
        every { registerService.register(any(), any()) } just runs
        every { loginService.validateUser(any(), any()) } just runs
        every { jwtProcessor.generateToken(any(), any()) } returns "example-token"

        given()
            .contentType(ContentType.JSON)
            .body(exampleUserRegisterRequest())
            .post("/api/v1/register")
        .then()
            .status(HttpStatus.OK)
            .apply(document("회원 가입", requestPreprocessor(), responsePreprocessor(),
                    responseFields(
                        fieldWithPath("result").type(JsonFieldType.STRING).description("Success"),
                        fieldWithPath("data").type(JsonFieldType.NULL).ignored(),
                        fieldWithPath("error").type(JsonFieldType.NULL).ignored(),
                    ),
                ),
            )
    }

    private fun exampleUserRegisterRequest() = UserRegisterRequest(
        email = "example@example.com",
        phoneNumber = "123-456-7890",
        username = "john_doe",
        password = "password123",
        checkPassword = "password123",
        city = "서울 특별시",
        province = "강남구",
        detail = "강남역 10번 출구",
    )


//    @Test
//    fun examplePost() {
//        every { exampleService.processExample(any()) } returns ExampleResult("BYE")
//
//        given()
//            .contentType(ContentType.JSON)
//            .body(ExampleRequestDto("HELLO_BODY"))
//            .post("/post")
//            .then()
//            .status(HttpStatus.OK)
//            .apply(
//                document(
//                    "examplePost",
//                    requestPreprocessor(),
//                    responsePreprocessor(),
//                    requestFields(
//                        fieldWithPath("data").type(JsonFieldType.STRING).description("ExampleBody Data Field"),
//                    ),
//                    responseFields(
//                        fieldWithPath("result").type(JsonFieldType.STRING).description("ResultType"),
//                        fieldWithPath("data.result").type(JsonFieldType.STRING).description("Result Date"),
//                        fieldWithPath("error").type(JsonFieldType.STRING).ignored(),
//                    ),
//                ),
//            )
//    }
}
