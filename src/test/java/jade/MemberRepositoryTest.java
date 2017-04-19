package jade;

import jade.domain.Community;
import jade.domain.Member;
import jade.repository.CommunityRepository;
import jade.repository.MemberRepository;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {
  @Autowired
  private MemberRepository memberRepository;

  @Autowired
  private CommunityRepository communityRepository;

  @Before
  @Transactional
  public void setUp() {
    Community community1 = new Community("sports", "sports community");
    Community community2 = new Community("reading", "reading community");
    List<Community> communities = Arrays.asList(community1, community2);

    Member member1 = new Member("jade", "1234");
    member1.setCommunities(communities);

    Member member2 = new Member("jennifer", "1234");
    member2.setCommunities(communities);

    List<Member> members = Arrays.asList(member1, member2);
    community1.setMembers(members);
    community2.setMembers(members);

    memberRepository.save(members);
    communityRepository.save(communities);
  }

  @After
  @Transactional
  public void tearDown() {
    memberRepository.deleteAll();
    communityRepository.deleteAll();
  }

  @Test
  @Transactional
  public void test() {
    Member foundMember1 = memberRepository.findOne(1L);
    Assert.assertNotNull(foundMember1);
    Assert.assertNotNull(foundMember1.getCommunities());
    Assert.assertEquals(2, foundMember1.getCommunities().size());

    Member foundMember2 = memberRepository.findOne(2L);
    Assert.assertNotNull(foundMember2);
    Assert.assertNotNull(foundMember2.getCommunities());
    Assert.assertEquals(2, foundMember2.getCommunities().size());
  }

  @Test
  @Transactional
  public void test2() {
    Community foundCommunity1 = communityRepository.findOne(1L);
    Assert.assertNotNull(foundCommunity1);
    Assert.assertNotNull(foundCommunity1.getMembers());
    Assert.assertEquals(2, foundCommunity1.getMembers().size());
  }
}
