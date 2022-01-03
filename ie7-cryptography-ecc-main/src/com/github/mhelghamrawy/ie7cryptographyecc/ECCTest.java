package com.github.mhelghamrawy.ie7cryptographyecc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;

import com.github.mhelghamrawy.ie7cryptographyecc.domain.EcPoint;
import com.github.mhelghamrawy.ie7cryptographyecc.domain.EccParameterSpec;
import com.github.mhelghamrawy.ie7cryptographyecc.util.EcPointArithmetic;

class ECCTest {
	
	EcPointArithmetic curve = new EcPointArithmetic(EccParameterSpec.SEC_P256_K1);
	
	/*
	 * Test Vectors
	 * https://chuckbatson.wordpress.com/2014/11/26/secp256k1-test-vectors/amp/
	 */
	
	@Test
	void test1() {
		
		long k1 = 1;
		EcPoint ecPoint1 = curve.scalarMultiply(BigInteger.valueOf(k1), curve.getEccSpec().getG());
		EcPoint ecPointC1 = new EcPoint(
				new BigInteger("79BE667EF9DCBBAC55A06295CE870B07029BFCDB2DCE28D959F2815B16F81798", 16), 
				new BigInteger("483ADA7726A3C4655DA4FBFC0E1108A8FD17B448A68554199C47D08FFB10D4B8", 16)
				);
		assertEquals(ecPointC1, ecPoint1);
		
		long k2 = 2;
		EcPoint ecPoint2 = curve.scalarMultiply(BigInteger.valueOf(k2), curve.getEccSpec().getG());
		EcPoint ecPointC2 = new EcPoint(
				new BigInteger("C6047F9441ED7D6D3045406E95C07CD85C778E4B8CEF3CA7ABAC09B95C709EE5", 16), 
				new BigInteger("1AE168FEA63DC339A3C58419466CEAEEF7F632653266D0E1236431A950CFE52A", 16)
				);
		assertEquals(ecPointC2, ecPoint2);
		
		long k3 = 3;
		EcPoint ecPoint3 = curve.scalarMultiply(BigInteger.valueOf(k3), curve.getEccSpec().getG());
		EcPoint ecPointC3 = new EcPoint(
				new BigInteger("F9308A019258C31049344F85F89D5229B531C845836F99B08601F113BCE036F9", 16), 
				new BigInteger("388F7B0F632DE8140FE337E62A37F3566500A99934C2231B6CB9FD7584B8E672", 16)
				);
		assertEquals(ecPointC3, ecPoint3);
		
		long k4 = 4;
		EcPoint ecPoint4 = curve.scalarMultiply(BigInteger.valueOf(k4), curve.getEccSpec().getG());
		EcPoint ecPointC4 = new EcPoint(
				new BigInteger("E493DBF1C10D80F3581E4904930B1404CC6C13900EE0758474FA94ABE8C4CD13", 16), 
				new BigInteger("51ED993EA0D455B75642E2098EA51448D967AE33BFBDFE40CFE97BDC47739922", 16)
				);
		assertEquals(ecPointC4, ecPoint4);
		
		long k5 = 5;
		EcPoint ecPoint5 = curve.scalarMultiply(BigInteger.valueOf(k5), curve.getEccSpec().getG());
		EcPoint ecPointC5 = new EcPoint(
				new BigInteger("2F8BDE4D1A07209355B4A7250A5C5128E88B84BDDC619AB7CBA8D569B240EFE4", 16), 
				new BigInteger("D8AC222636E5E3D6D4DBA9DDA6C9C426F788271BAB0D6840DCA87D3AA6AC62D6", 16)
				);
		assertEquals(ecPointC5, ecPoint5);
		
		long k6 = 6;
		EcPoint ecPoint6 = curve.scalarMultiply(BigInteger.valueOf(k6), curve.getEccSpec().getG());
		EcPoint ecPointC6 = new EcPoint(
				new BigInteger("FFF97BD5755EEEA420453A14355235D382F6472F8568A18B2F057A1460297556", 16), 
				new BigInteger("AE12777AACFBB620F3BE96017F45C560DE80F0F6518FE4A03C870C36B075F297", 16)
				);
		assertEquals(ecPointC6, ecPoint6);
		
		long k7 = 7;
		EcPoint ecPoint7 = curve.scalarMultiply(BigInteger.valueOf(k7), curve.getEccSpec().getG());
		EcPoint ecPointC7 = new EcPoint(
				new BigInteger("5CBDF0646E5DB4EAA398F365F2EA7A0E3D419B7E0330E39CE92BDDEDCAC4F9BC", 16), 
				new BigInteger("6AEBCA40BA255960A3178D6D861A54DBA813D0B813FDE7B5A5082628087264DA", 16)
				);
		assertEquals(ecPointC7, ecPoint7);
		
		long k8 = 8;
		EcPoint ecPoint8 = curve.scalarMultiply(BigInteger.valueOf(k8), curve.getEccSpec().getG());
		EcPoint ecPointC8 = new EcPoint(
				new BigInteger("2F01E5E15CCA351DAFF3843FB70F3C2F0A1BDD05E5AF888A67784EF3E10A2A01", 16), 
				new BigInteger("5C4DA8A741539949293D082A132D13B4C2E213D6BA5B7617B5DA2CB76CBDE904", 16)
				);
		assertEquals(ecPointC8, ecPoint8);
		
		long k9 = 9;
		EcPoint ecPoint9 = curve.scalarMultiply(BigInteger.valueOf(k9), curve.getEccSpec().getG());
		EcPoint ecPointC9 = new EcPoint(
				new BigInteger("ACD484E2F0C7F65309AD178A9F559ABDE09796974C57E714C35F110DFC27CCBE", 16), 
				new BigInteger("CC338921B0A7D9FD64380971763B61E9ADD888A4375F8E0F05CC262AC64F9C37", 16)
				);
		assertEquals(ecPointC9, ecPoint9);
		
		long k10 = 10;
		EcPoint ecPoint10 = curve.scalarMultiply(BigInteger.valueOf(k10), curve.getEccSpec().getG());
		EcPoint ecPointC10 = new EcPoint(
				new BigInteger("A0434D9E47F3C86235477C7B1AE6AE5D3442D49B1943C2B752A68E2A47E247C7", 16), 
				new BigInteger("893ABA425419BC27A3B6C7E693A24C696F794C2ED877A1593CBEE53B037368D7", 16)
				);
		assertEquals(ecPointC10, ecPoint10);
		
		long k11 = 11;
		EcPoint ecPoint11 = curve.scalarMultiply(BigInteger.valueOf(k11), curve.getEccSpec().getG());
		EcPoint ecPointC11 = new EcPoint(
				new BigInteger("774AE7F858A9411E5EF4246B70C65AAC5649980BE5C17891BBEC17895DA008CB", 16), 
				new BigInteger("D984A032EB6B5E190243DD56D7B7B365372DB1E2DFF9D6A8301D74C9C953C61B", 16)
				);
		assertEquals(ecPointC11, ecPoint11);
		
		long k12 = 12;
		EcPoint ecPoint12 = curve.scalarMultiply(BigInteger.valueOf(k12), curve.getEccSpec().getG());
		EcPoint ecPointC12 = new EcPoint(
				new BigInteger("D01115D548E7561B15C38F004D734633687CF4419620095BC5B0F47070AFE85A", 16), 
				new BigInteger("A9F34FFDC815E0D7A8B64537E17BD81579238C5DD9A86D526B051B13F4062327", 16)
				);
		assertEquals(ecPointC12, ecPoint12);
		
		long k13 = 13;
		EcPoint ecPoint13 = curve.scalarMultiply(BigInteger.valueOf(k13), curve.getEccSpec().getG());
		EcPoint ecPointC13 = new EcPoint(
				new BigInteger("F28773C2D975288BC7D1D205C3748651B075FBC6610E58CDDEEDDF8F19405AA8", 16), 
				new BigInteger("0AB0902E8D880A89758212EB65CDAF473A1A06DA521FA91F29B5CB52DB03ED81", 16)
				);
		assertEquals(ecPointC13, ecPoint13);
		
		long k14 = 14;
		EcPoint ecPoint14 = curve.scalarMultiply(BigInteger.valueOf(k14), curve.getEccSpec().getG());
		EcPoint ecPointC14 = new EcPoint(
				new BigInteger("499FDF9E895E719CFD64E67F07D38E3226AA7B63678949E6E49B241A60E823E4", 16), 
				new BigInteger("CAC2F6C4B54E855190F044E4A7B3D464464279C27A3F95BCC65F40D403A13F5B", 16)
				);
		assertEquals(ecPointC14, ecPoint14);
		
		long k15 = 15;
		EcPoint ecPoint15 = curve.scalarMultiply(BigInteger.valueOf(k15), curve.getEccSpec().getG());
		EcPoint ecPointC15 = new EcPoint(
				new BigInteger("D7924D4F7D43EA965A465AE3095FF41131E5946F3C85F79E44ADBCF8E27E080E", 16), 
				new BigInteger("581E2872A86C72A683842EC228CC6DEFEA40AF2BD896D3A5C504DC9FF6A26B58", 16)
				);
		assertEquals(ecPointC15, ecPoint15);
		
		long k16 = 16;
		EcPoint ecPoint16 = curve.scalarMultiply(BigInteger.valueOf(k16), curve.getEccSpec().getG());
		EcPoint ecPointC16 = new EcPoint(
				new BigInteger("E60FCE93B59E9EC53011AABC21C23E97B2A31369B87A5AE9C44EE89E2A6DEC0A", 16), 
				new BigInteger("F7E3507399E595929DB99F34F57937101296891E44D23F0BE1F32CCE69616821", 16)
				);
		assertEquals(ecPointC16, ecPoint16);
		
		long k17 = 17;
		EcPoint ecPoint17 = curve.scalarMultiply(BigInteger.valueOf(k17), curve.getEccSpec().getG());
		EcPoint ecPointC17 = new EcPoint(
				new BigInteger("DEFDEA4CDB677750A420FEE807EACF21EB9898AE79B9768766E4FAA04A2D4A34", 16), 
				new BigInteger("4211AB0694635168E997B0EAD2A93DAECED1F4A04A95C0F6CFB199F69E56EB77", 16)
				);
		assertEquals(ecPointC17, ecPoint17);
		
		long k18 = 18;
		EcPoint ecPoint18 = curve.scalarMultiply(BigInteger.valueOf(k18), curve.getEccSpec().getG());
		EcPoint ecPointC18 = new EcPoint(
				new BigInteger("5601570CB47F238D2B0286DB4A990FA0F3BA28D1A319F5E7CF55C2A2444DA7CC", 16), 
				new BigInteger("C136C1DC0CBEB930E9E298043589351D81D8E0BC736AE2A1F5192E5E8B061D58", 16)
				);
		assertEquals(ecPointC18, ecPoint18);
		
		long k19 = 19;
		EcPoint ecPoint19 = curve.scalarMultiply(BigInteger.valueOf(k19), curve.getEccSpec().getG());
		EcPoint ecPointC19 = new EcPoint(
				new BigInteger("2B4EA0A797A443D293EF5CFF444F4979F06ACFEBD7E86D277475656138385B6C", 16), 
				new BigInteger("85E89BC037945D93B343083B5A1C86131A01F60C50269763B570C854E5C09B7A", 16)
				);
		assertEquals(ecPointC19, ecPoint19);
		
		long k20 = 20;
		EcPoint ecPoint20 = curve.scalarMultiply(BigInteger.valueOf(k20), curve.getEccSpec().getG());
		EcPoint ecPointC20 = new EcPoint(
				new BigInteger("4CE119C96E2FA357200B559B2F7DD5A5F02D5290AFF74B03F3E471B273211C97", 16), 
				new BigInteger("12BA26DCB10EC1625DA61FA10A844C676162948271D96967450288EE9233DC3A", 16)
				);
		assertEquals(ecPointC20, ecPoint20);
		
		/*long k21 = 112233445566778899;
		EcPoint ecPoint21 = curve.scalarMultiply(BigInteger.valueOf(k20), curve.getEccSpec().getG());
		EcPoint ecPointC21 = new EcPoint(
				new BigInteger("4CE119C96E2FA357200B559B2F7DD5A5F02D5290AFF74B03F3E471B273211C97", 16), 
				new BigInteger("12BA26DCB10EC1625DA61FA10A844C676162948271D96967450288EE9233DC3A", 16)
				);
		assertEquals(ecPointC21, ecPoint21);
		
		long k22 = 20;
		EcPoint ecPoint22 = curve.scalarMultiply(BigInteger.valueOf(k20), curve.getEccSpec().getG());
		EcPoint ecPointC22 = new EcPoint(
				new BigInteger("4CE119C96E2FA357200B559B2F7DD5A5F02D5290AFF74B03F3E471B273211C97", 16), 
				new BigInteger("12BA26DCB10EC1625DA61FA10A844C676162948271D96967450288EE9233DC3A", 16)
				);
		assertEquals(ecPointC22, ecPoint22);
		
		long k23 = 20;
		EcPoint ecPoint23 = curve.scalarMultiply(BigInteger.valueOf(k20), curve.getEccSpec().getG());
		EcPoint ecPointC23 = new EcPoint(
				new BigInteger("4CE119C96E2FA357200B559B2F7DD5A5F02D5290AFF74B03F3E471B273211C97", 16), 
				new BigInteger("12BA26DCB10EC1625DA61FA10A844C676162948271D96967450288EE9233DC3A", 16)
				);
		assertEquals(ecPointC23, ecPoint23);
		
		long k24 = 20;
		EcPoint ecPoint24 = curve.scalarMultiply(BigInteger.valueOf(k20), curve.getEccSpec().getG());
		EcPoint ecPointC24 = new EcPoint(
				new BigInteger("4CE119C96E2FA357200B559B2F7DD5A5F02D5290AFF74B03F3E471B273211C97", 16), 
				new BigInteger("12BA26DCB10EC1625DA61FA10A844C676162948271D96967450288EE9233DC3A", 16)
				);
		assertEquals(ecPointC24, ecPoint24);
		
		long k25 = 20;
		EcPoint ecPoint25 = curve.scalarMultiply(BigInteger.valueOf(k20), curve.getEccSpec().getG());
		EcPoint ecPointC25 = new EcPoint(
				new BigInteger("4CE119C96E2FA357200B559B2F7DD5A5F02D5290AFF74B03F3E471B273211C97", 16), 
				new BigInteger("12BA26DCB10EC1625DA61FA10A844C676162948271D96967450288EE9233DC3A", 16)
				);
		assertEquals(ecPointC25, ecPoint25);
		
	*/
		
	}
	
}
