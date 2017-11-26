/*
 * Copyright 2017 George Aristy.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.llorllale.netbeans.youtrack.issues;

import org.llorllale.netbeans.youtrack.issues.mock.MockFrame;
import java.util.concurrent.atomic.AtomicBoolean;
import static org.assertj.core.api.Java6Assertions.assertThat;
import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Unit tests for {@link DefaultRepoConfig}.
 * 
 * @author George Aristy (george.aristy@gmail.com)
 * @since 0.2.0
 */
public class DefaultRepoConfigTest {
  private static final String PROJECT_ID_TXTBOX = "projectIdTxtBox";
  private static final String API_URL_TXTBOX = "apiUrlTxtBox";
  private static final String TOKEN_TXTBOX = "tokenTxtBox";
  private static final String TEST_BUTTON = "testBtn";

  private FrameFixture window;

  @BeforeClass
  public static void setup() {
    FailOnThreadViolationRepaintManager.install();
  }

  @After
  public void after() {
    this.window.cleanUp();
  }

  /**
   * {@link DefaultRepoConfig#projectId()} should return what is typed in the project ID text box.
   * 
   * @since 0.2.0
   */
  @Test
  public void projectId() {
    final String inputText = "TP-1234";
    final DefaultRepoConfig config = this.showNewConfig().component();
    this.window.textBox(PROJECT_ID_TXTBOX).enterText(inputText);

    assertThat(config.projectId()).isEqualTo(inputText);
  }

  /**
   * {@link DefaultRepoConfig#apiUrl()} should return what is typed in the URL text box.
   * 
   * @since 0.2.0
   */
  @Test
  public void apiUrl() {
    final String inputText = "http://some.youtrack.url.com/rest";
    final DefaultRepoConfig config = this.showNewConfig().component();
    this.window.textBox(API_URL_TXTBOX).enterText(inputText);

    assertThat(config.apiUrl()).isEqualTo(inputText);
  }

  /**
   * {@link DefaultRepoConfig#userToken()} should return what is typed in the token text box.
   * 
   * @since 0.2.0
   */
  @Test
  public void userToken() {
    final String inputText = "perm:23lk4jl23k4j5lk3jlkj3lkjl3kj5lkj2";
    final DefaultRepoConfig config = this.showNewConfig().component();
    this.window.textBox(TOKEN_TXTBOX).enterText(inputText);

    assertThat(config.userToken()).isEqualTo(inputText);
  }

  /**
   * {@link DefaultRepoConfig#view()} must return a component.
   * 
   * @since 0.2.0
   */
  @Test
  public void view() {
    assertThat(this.showNewConfig().component().view()).isNotNull();
  }

  /**
   * {@link DefaultRepoConfig#onTestBtn(java.awt.event.ActionListener)} should call the given
   * listener.
   * 
   * @since 0.2.0
   */
  @Test
  public void onTestBtn() {
    final AtomicBoolean flag = new AtomicBoolean(false);
    this.showNewConfig().component().onTestBtn(e -> flag.set(true));
    this.window.button(TEST_BUTTON).click();

    assertThat(flag).isTrue();
  }

  /**
   * Creates a new {@link DefaultRepoConfig} and visually displays it.
   * 
   * @return the new {@link MockFrame} holding the new {@link DefaultRepoConfig} component.
   * @since 0.2.0
   */
  private MockFrame<DefaultRepoConfig> showNewConfig() {
    final MockFrame<DefaultRepoConfig> frame = GuiActionRunner.execute(
        () -> new MockFrame<>(new DefaultRepoConfig())
    );
    this.window = new FrameFixture(frame);
    this.window.robot().settings().delayBetweenEvents(0); //speeds up input
    this.window.show();
    return frame;
  }
}